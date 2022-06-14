
# Wprowadznie do testow jednostkowych w Javie
Repozytorium do warsztatu wprowadzającego do testowania w Javie
### Zaleznosci uzyte w repozytirum
JUnit w wersji 5:
```bash
testImplementation 'org.junit.jupiter:junit-jupiter-api:5.7.2'
testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.7.2'
```
AssertJ:
```bash
testImplementation "org.assertj:assertj-core:3.11.1"
```

JUnit 5 Params
```bash
testImplementation group: 'org.junit.jupiter', name: 'junit-jupiter-params', version: '5.4.2'
```
Mockito
```bash
testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.1'
testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.8.1'
```


### Tworzenie Live Templates w IntelliJ
Live template ulatwia nam pewne powtarzalne rzeczy w IntelliJ
1. zaznaczamy dany obszar w intellij
2. naciskamy skrot na windows ``ctrl+alt+t`` na mac ``command + option + t``
3. wybieramy Configure Live Templates
4. naciskamy plusika i dodajemy nowy Live Template

### Uruchomianie testów przy pomocy IntelliJ, a nie narzędzia automatyzującego
1. Ustawienia -> Build,Execution,Deployment -> Build Tools -> Gradle/Maven
2. Ustaw pole "Run tests using" na IntelliJ IDEA

### Przydatne linki:
* [Dokumentacja JUnit 5](https://junit.org/junit5/docs/current/user-guide/)
* [Darmowe do pobrania JDK od Amazonu](https://aws.amazon.com/corretto/?filtered-posts.sort-by=item.additionalFields.createdDate&filtered-posts.sort-order=desc)
* [IntellIJ IDEA](https://www.jetbrains.com/idea/download/)
* [AssertJ dokumentacja](https://joel-costigliola.github.io/assertj/)
* [Mockito](https://site.mockito.org/)