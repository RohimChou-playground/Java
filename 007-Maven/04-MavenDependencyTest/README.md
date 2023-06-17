sayhiutil-1.0.jar will say "hi"
sayhiutil-2.0.jar will say "hihi"

log4a.jar uses sayhiutil-1.0.jar internally
db.jar uses log4b.jar uses sayhiutil-2.0.jar internally

dependency tree graph:
```
consoleapp
├── log4a.jar
│   └── sayhiutil-1.0.jar
└── db.jar
    └── log4b.jar
        └── sayhiutil-2.0.jar
```







