import 'package:flutter/material.dart';
import 'package:trip_event_planner/models/event.dart';
import 'dart:async';

class EventCard extends StatefulWidget {
  final Event event;
  final VoidCallback onDelete;

  const EventCard({super.key, required this.event, required this.onDelete});

  @override
  State<EventCard> createState() => _EventCardState();
}

class _EventCardState extends State<EventCard> {
  late Duration _timeRemaining;
  late Timer _timer;
  late double _progress;

  @override
  void initState() {
    super.initState();
    _updateCountdown();
    _timer = Timer.periodic(const Duration(seconds: 1), (timer) {
      _updateCountdown();
    });
  }

  void _updateCountdown() {
    final now = DateTime.now();
    setState(() {
      _timeRemaining = widget.event.date.difference(now);
      _progress = _calculateProgress();
    });
  }

  double _calculateProgress() {
    final totalDuration = widget.event.date.difference(DateTime.now());
    final initialDuration = widget.event.date.difference(widget.event.date.subtract(const Duration(days: 30)));
    return totalDuration.isNegative ? 1.0 : (1 - (totalDuration.inSeconds / initialDuration.inSeconds)).clamp(0.0, 1.0);
  }

  String _formatDuration(Duration duration) {
    if (duration.isNegative) {
      return 'Event Completed';
    }
    final days = duration.inDays;
    final hours = duration.inHours % 24;
    final minutes = duration.inMinutes % 60;
    final seconds = duration.inSeconds % 60;
    return '$days days, $hours hours, $minutes minutes, $seconds seconds remaining';
  }

  Color _getCategoryColor(String category) {
    switch (category) {
      case 'Personal':
        return Colors.blue;
      case 'Work':
        return Colors.orange;
      case 'Travel':
        return Colors.green;
      case 'Party':
        return Colors.purple;
      case 'Other':
      default:
        return Colors.grey;
    }
  }

  @override
  void dispose() {
    _timer.cancel();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Card(
      margin: const EdgeInsets.symmetric(vertical: 8, horizontal: 16),
      child: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            // Title & Category Badge
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Text(
                  widget.event.title,
                  style: const TextStyle(fontSize: 16, fontWeight: FontWeight.bold),
                ),
                Container(
                  padding: const EdgeInsets.symmetric(horizontal: 8, vertical: 4),
                  decoration: BoxDecoration(
                    color: _getCategoryColor(widget.event.category),
                    borderRadius: BorderRadius.circular(12),
                  ),
                  child: Text(
                    widget.event.category,
                    style: const TextStyle(color: Colors.white, fontSize: 12),
                  ),
                ),
              ],
            ),
            const SizedBox(height: 4),

            // Event Date
            Text(
              '${widget.event.date.toLocal()}'.split(' ')[0],
              style: const TextStyle(color: Colors.grey),
            ),
            const SizedBox(height: 4),

            // Countdown Timer
            Text(
              _formatDuration(_timeRemaining),
              style: const TextStyle(color: Colors.green),
            ),
            const SizedBox(height: 8),

            // Progress Bar
            LinearProgressIndicator(
              value: _progress,
              backgroundColor: Colors.grey[300],
              color: Colors.blue,
              minHeight: 6,
            ),
            const SizedBox(height: 8),

            // Delete Button
            Align(
              alignment: Alignment.centerRight,
              child: IconButton(
                icon: const Icon(Icons.delete, color: Colors.red),
                onPressed: widget.onDelete,
              ),
            ),
          ],
        ),
      ),
    );
  }
}
