# jsf-icefaces-agenda
Aplicativo JSF que faz o controle de uma agenda, usando requisições ajax (icefaces). Ocorreram alguns erros com a versão 3.3 do icefaces, a versão 4.1.1 foi só adicionar as libs e não deu mais erros, usando o JSF Mojarra 2.2.1

Para alterar o BD, veja o arquivo em `src/hibernate.cfg.xml`

Libs adicionadas manualmente:

* ICEfaces-4.1.1-bin - API: http://www.icesoft.org/wiki/display/ICE/API+Documentation - Demos: http://www.icesoft.org/java/demos/icefaces-demos.jsf
 * lib/icefaces.jar
 * lib/icefaces-ace.jar


* Hibernate 5.0.9
 * hibernate-release-5.0.9.Final/lib/jpa
 * hibernate-release-5.0.9.Final/lib/required (core)


* JDBC-Driver
 * postgresql-9.4-1201.jdbc4

XMLNS:
```
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html"
      xmlns:ui="http://xmlns.jcp.org/jsf/facelets"
      xmlns:f="http://xmlns.jcp.org/jsf/core"
      xmlns:ace="http://www.icefaces.org/icefaces/components"
      xmlns:icecore="http://www.icefaces.org/icefaces/core">
```
* Para a IDE reconhecer e auto-completar as tags **ace** e **icecore** File > Settings > Schemas and DTDs > add (+)
 * no campo URI coloque a URL (ex: `http://www.icefaces.org/icefaces/components`), no campo Location coloque o path para lib/*.jar/META-INF/*.tld (ex: `lib/icefaces-ace.jar/META-INF/components.tld`)