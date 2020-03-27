https://github.com/edenhill/kafkacat

kafkacat in `metadata list` mode:

```bash
$ kafkacat -Q -b kafka:9092
```

kafkacat in `producer` mode:

```bash
$ echo "message" | kafkacat -P -b kafka:9092 -t lines-topic
```

kafkacat in `consumer` mode

```bash
kafkacat -C -b kafka:9092 -t lines-topic
```

