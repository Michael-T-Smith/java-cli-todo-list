# Java CLI-Todo-list

## Purpose

A command line tool for managing a personal list of tasks.

## Requirements

The application shall: 

- Create tasks
- List tasks
- Mark tasks as complete
- Delete tasks
- Persist tasks

## Non-Requirements

The application shall not:

- Support multiple users
- Synchronize across machines
- Support concurrent access

## Persistence Guarantee

When a task operation succeeds, all task data will survive application closure and restart. 

## Data model

Task: 
- id: uuid
- description: String
- created_at: LocalDateTime
- completed: Boolean
