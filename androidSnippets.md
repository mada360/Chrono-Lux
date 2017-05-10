# Useful Android Code Snippets

## Notifications

### Create

``` Java
private void showNotification() {
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getContext())
                .setContentTitle("Chrono-Lux")
                .setContentText("Alarm Set")
                .setTicker("Alarm has been set")
                .setSmallIcon(R.drawable.ic_alarm_black_24dp);

        Intent moreInfoIntent = new Intent(getContext(), BasicIntent.class);

        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(getContext());


        taskStackBuilder.addParentStack(BasicIntent.class);
        taskStackBuilder.addNextIntent(moreInfoIntent);

        final PendingIntent pendingIntent = taskStackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        notificationBuilder.setContentIntent(pendingIntent);

        notificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(notifID, notificationBuilder.build());

        isNotificationActive = true;
    }
```


### Remove

```Java
private void removeNotification() {
    if (isNotificationActive){
            notificationManager.cancel(notifID);
            }
    }

```

### Delay

```Java
private void delayNotification() {
        Intent alertIntent = new Intent(getContext(), MyReceiver.class);
        AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 13);

        alarmManager.setRepeating(
                AlarmManager.RTC_WAKEUP,
                calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY,
                PendingIntent
                        .getBroadcast(
                                getContext(),
                                1,
                                alertIntent,
                                PendingIntent.FLAG_UPDATE_CURRENT
                        )
        );
    }
```

## Time Picker

``` Java
TimePickerDialog.OnTimeSetListener time = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
            dateTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateTime.set(Calendar.MINUTE, minute);
            updateTextLabel();
        }
    };

    private void pickTime() {
        new TimePickerDialog(
                getContext(),
                time,
                dateTime.get(Calendar.HOUR_OF_DAY),
                dateTime.get(Calendar.MINUTE),
                true
        ).show();
    }

```
