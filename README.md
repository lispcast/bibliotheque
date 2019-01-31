# bibliotheque

generated using Luminus version "2.9.10.69"

FIXME

## Prerequisites

You will need [Leiningen][1] 2.0 or above installed.

[1]: https://github.com/technomancy/leiningen

## Running

First, you need a database. If you're using PostgreSQL,
create a new database:

```bash
createdb biblioteque
```

Then run the migrations:

```bash
DATABASE_URL=jdbc:postgresql://localhost/biblioteque lein migratus migrate
```

To start a web server for the application, run:

```bash
DATABASE_URL=jdbc:postgresql://localhost/biblioteque lein run
```

## License

Copyright © 2016 FIXME
