import 'package:flutter/material.dart';
import 'package:trip_event_planner/models/event.dart';
import 'package:trip_event_planner/widgets/event_card.dart';

class UpcomingEventsScreen extends StatelessWidget {
  final List<Event> events;

  const UpcomingEventsScreen({super.key, required this.events});

  @override
  Widget build(BuildContext context) {
    List<Event> upcomingEvents = events
        .where((event) => event.date.isAfter(DateTime.now()))
        .toList();

    return Scaffold(
      appBar: AppBar(title: const Text('Upcoming Events')),
      body: upcomingEvents.isEmpty
          ? const Center(
              child: Text('No upcoming events!'),
            )
          : ListView.builder(
              itemCount: upcomingEvents.length,
              itemBuilder: (context, index) {
                return EventCard(
                  event: upcomingEvents[index],
                  onDelete: () {},
                );
              },
            ),
    );
  }
}
