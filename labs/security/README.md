The default format used for these files is JKS until Java 8. Since Java 9, though, the default keystore format is PKCS12

```bash
./certs-create.sh

------------------------------- kafka -------------------------------
Signature ok
subject=/C=US/ST=Ca/L=PaloAlto/O=CONFLUENT/OU=TEST/CN=kafka
Getting CA Private Key
Certificate was added to keystore
Certificate reply was installed in keystore
Certificate was added to keystore
Certificate stored in file <kafka.der>
Importing keystore kafka.kafka.keystore.jks to kafka.keystore.p12...
Entry for alias kafka successfully imported.
Entry for alias caroot successfully imported.
Import command completed:  2 entries successfully imported, 0 entries failed or cancelled
MAC verified OK
------------------------------- client -------------------------------
Signature ok
subject=/C=US/ST=Ca/L=PaloAlto/O=CONFLUENT/OU=TEST/CN=client
Getting CA Private Key
Certificate was added to keystore
Certificate reply was installed in keystore
Certificate was added to keystore
Certificate stored in file <client.der>
Importing keystore kafka.client.keystore.jks to client.keystore.p12...
Entry for alias client successfully imported.
Entry for alias caroot successfully imported.
Import command completed:  2 entries successfully imported, 0 entries failed or cancelled
MAC verified OK
------------------------------- schemaregistry -------------------------------
Signature ok
subject=/C=US/ST=Ca/L=PaloAlto/O=CONFLUENT/OU=TEST/CN=schemaregistry
Getting CA Private Key
Certificate was added to keystore
Certificate reply was installed in keystore
Certificate was added to keystore
Certificate stored in file <schemaregistry.der>
Importing keystore kafka.schemaregistry.keystore.jks to schemaregistry.keystore.p12...
Entry for alias schemaregistry successfully imported.
Entry for alias caroot successfully imported.
Import command completed:  2 entries successfully imported, 0 entries failed or cancelled
MAC verified OK
```

```bash
------------------------------- kafka keystore -------------------------------
Alias name: kafka
Entry type: PrivateKeyEntry
Alias name: caroot
Entry type: trustedCertEntry
------------------------------- kafka truststore -------------------------------
Alias name: caroot
Entry type: trustedCertEntry
------------------------------- client keystore -------------------------------
Alias name: client
Entry type: PrivateKeyEntry
Alias name: caroot
Entry type: trustedCertEntry
------------------------------- client truststore -------------------------------
Alias name: caroot
Entry type: trustedCertEntry
------------------------------- schemaregistry keystore -------------------------------
Alias name: schemaregistry
Entry type: PrivateKeyEntry
Alias name: caroot
Entry type: trustedCertEntry
------------------------------- schemaregistry truststore -------------------------------
Alias name: caroot
Entry type: trustedCertEntry
```