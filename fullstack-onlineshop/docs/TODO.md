# TODO

This document tracks remaining work for the application.

## General

- Add image upload support
- Add order status workflow with admin updates
- Real-time product updates for all users when admins make changes
- Provide Docker images for both UI (nginx) and backend

## Backend Specific

- Implement order status state machine
- Subscribe to RabbitMQ for external order status updates
- Switch to Keycloak with OAuth instead of local password management
- New strategy: find the product in multiple locations if one single location does not cover the required order quantity
- New table: Supplier (use skill to generate model, fetch lazy, etc)

## Frontend Specific

- Accessibility menu for font size, contrast, and related settings
- Add internationalization (i18n) to the application
- Migrate state management to NGRX Signal Store
- Set delivery address for orders in UI
