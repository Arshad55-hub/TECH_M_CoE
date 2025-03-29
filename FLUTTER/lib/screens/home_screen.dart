import 'package:flutter/material.dart';
import 'package:trip_event_planner/models/event.dart';
import 'package:trip_event_planner/screens/add_event_screen.dart';
import 'package:trip_event_planner/screens/event_details_screen.dart';
import 'package:trip_event_planner/screens/upcoming_events_screen.dart';
import 'package:trip_event_planner/screens/past_events_screen.dart';
import 'package:trip_event_planner/screens/settings_screen.dart';
import 'package:trip_event_planner/screens/profile_screen.dart';
import 'package:trip_event_planner/widgets/event_card.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  List<Event> events = [];
  List<Event> filteredEvents = [];
  String searchQuery = '';

  @override
  void initState() {
    super.initState();
    filteredEvents = events;
  }

  void addEvent(Event event) {
    setState(() {
      events.add(event);
      _sortAndFilterEvents();
    });
  }

  void deleteEvent(int index) {
    setState(() {
      events.removeAt(index);
      _sortAndFilterEvents();
    });
  }

  void _sortAndFilterEvents() {
    events.sort((a, b) => a.date.compareTo(b.date));
    filteredEvents = events
        .where((event) =>
            event.title.toLowerCase().contains(searchQuery.toLowerCase()))
        .toList();
  }

  void _navigateTo(String route) {
    switch (route) {
      case 'upcoming':
        Navigator.push(
          context,
          MaterialPageRoute(
            builder: (context) => UpcomingEventsScreen(events: events),
          ),
        );
        break;
      case 'past':
        Navigator.push(
          context,
          MaterialPageRoute(
            builder: (context) => PastEventsScreen(events: events),
          ),
        );
        break;
      case 'settings':
        Navigator.push(
          context,
          MaterialPageRoute(builder: (context) => const SettingsScreen()),
        );
        break;
      case 'profile':
        Navigator.push(
          context,
          MaterialPageRoute(builder: (context) => const ProfileScreen()),
        );
        break;
    }
  }

  void _onSearch(String query) {
    setState(() {
      searchQuery = query;
      _sortAndFilterEvents();
    });
  }

  Widget _buildEventSummary() {
    int upcomingCount =
        events.where((event) => event.date.isAfter(DateTime.now())).length;
    int pastCount =
        events.where((event) => event.date.isBefore(DateTime.now())).length;
    return Padding(
      padding: const EdgeInsets.all(12.0),
      child: Card(
        color: const Color(0xFF1E1E1E),
        elevation: 5,
        child: ListTile(
          leading: const Icon(Icons.event, color: Color(0xFF673AB7)),
          title: const Text(
            'Event Summary',
            style: TextStyle(
              fontSize: 18,
              fontWeight: FontWeight.bold,
              color: Colors.white,
            ),
          ),
          subtitle: Text(
            '🌟 Upcoming: $upcomingCount | 📅 Past: $pastCount',
            style: const TextStyle(
              color: Colors.grey,
              fontSize: 14,
            ),
          ),
        ),
      ),
    );
  }

  Widget _buildEventSuggestion() {
    if (events.isEmpty) {
      return const Padding(
        padding: EdgeInsets.all(12.0),
        child: Text(
          '🎁 Feeling adventurous? Plan an amazing trip this weekend! ✈️',
          textAlign: TextAlign.center,
          style: TextStyle(fontSize: 14, color: Colors.lightBlueAccent),
        ),
      );
    }
    return const SizedBox.shrink();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: const Color(0xFF121212),
      appBar: AppBar(
        backgroundColor: const Color(0xFF1E1E1E),
        title: const Text('Trip Event Planner'),
        actions: [
          IconButton(
            icon: const Icon(Icons.search, color: Colors.white),
            onPressed: () {
              showSearch(
                context: context,
                delegate: EventSearchDelegate(events, _onSearch),
              );
            },
          ),
        ],
      ),
      body: Column(
        children: [
          _buildEventSummary(),
          Expanded(
            child: filteredEvents.isEmpty
                ? const Center(
                    child: Text(
                      '🎉 No events added yet! 🎈\nTap the ➕ button to add a new event.',
                      textAlign: TextAlign.center,
                      style: TextStyle(
                          fontSize: 16,
                          fontWeight: FontWeight.bold,
                          color: Colors.white),
                    ),
                  )
                : ListView.builder(
                    itemCount: filteredEvents.length,
                    itemBuilder: (context, index) {
                      return GestureDetector(
                        onTap: () {
                          Navigator.push(
                            context,
                            MaterialPageRoute(
                              builder: (context) => EventDetailsScreen(
                                  event: filteredEvents[index]),
                            ),
                          );
                        },
                        child: EventCard(
                          event: filteredEvents[index],
                          onDelete: () => deleteEvent(index),
                        ),
                      );
                    },
                  ),
          ),
          _buildEventSuggestion(),
        ],
      ),
      floatingActionButton: FloatingActionButton(
        backgroundColor: const Color(0xFF673AB7),
        onPressed: () async {
          final newEvent = await Navigator.push(
            context,
            MaterialPageRoute(builder: (context) => const AddEventScreen()),
          );
          if (newEvent != null) {
            addEvent(newEvent);
          }
        },
        child: const Icon(Icons.add, color: Colors.white),
      ),
      drawer: Drawer(
        backgroundColor: const Color(0xFF1E1E1E),
        child: ListView(
          padding: EdgeInsets.zero,
          children: [
            const DrawerHeader(
              decoration: BoxDecoration(
                color: Color(0xFF673AB7),
              ),
              child: Text(
                'Menu',
                style: TextStyle(color: Colors.white, fontSize: 24),
              ),
            ),
            ListTile(
              leading: const Icon(Icons.upcoming, color: Colors.white),
              title: const Text('Upcoming Events',
                  style: TextStyle(color: Colors.white)),
              onTap: () => _navigateTo('upcoming'),
            ),
            ListTile(
              leading: const Icon(Icons.history, color: Colors.white),
              title: const Text('Past Events',
                  style: TextStyle(color: Colors.white)),
              onTap: () => _navigateTo('past'),
            ),
            ListTile(
              leading: const Icon(Icons.person, color: Colors.white),
              title: const Text('Profile',
                  style: TextStyle(color: Colors.white)),
              onTap: () => _navigateTo('profile'),
            ),
            ListTile(
              leading: const Icon(Icons.settings, color: Colors.white),
              title: const Text('Settings',
                  style: TextStyle(color: Colors.white)),
              onTap: () => _navigateTo('settings'),
            ),
          ],
        ),
      ),
    );
  }
}

class EventSearchDelegate extends SearchDelegate<String> {
  final List<Event> events;
  final Function(String) onSearch;

  EventSearchDelegate(this.events, this.onSearch);

  @override
  List<Widget> buildActions(BuildContext context) {
    return [
      IconButton(
        icon: const Icon(Icons.clear, color: Colors.white),
        onPressed: () {
          query = '';
          onSearch(query);
        },
      ),
    ];
  }

  @override
  Widget buildLeading(BuildContext context) {
    return IconButton(
      icon: const Icon(Icons.arrow_back, color: Colors.white),
      onPressed: () {
        close(context, '');
      },
    );
  }

  @override
  Widget buildResults(BuildContext context) {
    onSearch(query);
    return const SizedBox.shrink();
  }

  @override
  Widget buildSuggestions(BuildContext context) {
    final suggestions = events
        .where(
            (event) => event.title.toLowerCase().contains(query.toLowerCase()))
        .toList();

    return ListView.builder(
      itemCount: suggestions.length,
      itemBuilder: (context, index) {
        return ListTile(
          tileColor: const Color(0xFF1E1E1E),
          title: Text(suggestions[index].title,
              style: const TextStyle(color: Colors.white)),
          onTap: () {
            close(context, suggestions[index].title);
          },
        );
      },
    );
  }
}
