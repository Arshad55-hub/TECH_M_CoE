import 'package:flutter/material.dart';
import 'package:trip_event_planner/models/event.dart';
import 'package:trip_event_planner/widgets/event_card.dart';

class PastEventsScreen extends StatelessWidget {
  final List<Event> events;

  const PastEventsScreen({super.key, required this.events});

  @override
  Widget build(BuildContext context) {
    List<Event> pastEvents = events
        .where((event) => event.date.isBefore(DateTime.now()))
        .toList();

    return Scaffold(
      appBar: AppBar(title: const Text('Past Events')),
      body: pastEvents.isEmpty
          ? const Center(
              child: Text('No past events!'),
            )
          : ListView.builder(
              itemCount: pastEvents.length,
              itemBuilder: (context, index) {
                return EventCard(
                  event: pastEvents[index],
                  onDelete: () {},
                );
              },
            ),
    );
  }
}
