import 'package:flutter/material.dart';

class Event {
  String title;
  String description;
  DateTime date;
  String category;
  String? location; // Optional location
  String? priority; // Optional priority
  Color? color; // Optional color for event
  TimeOfDay? startTime; // Optional start time
  TimeOfDay? endTime; // Optional end time
  int? reminderMinutes; // Optional reminder time in minutes

  Event({
    required this.title,
    required this.description,
    required this.date,
    required this.category,
    this.location,
    this.priority,
    this.color,
    this.startTime,
    this.endTime,
    this.reminderMinutes,
  });
}
