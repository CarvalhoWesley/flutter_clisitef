No caminho `android/app` você deve criar um arquivo chamado proguard-rules.pro e adicionar as seguintes informações:

```
-keep class br.com.setis.** { *; }
-keep class br.com.softwareexpress.** { *; }
```