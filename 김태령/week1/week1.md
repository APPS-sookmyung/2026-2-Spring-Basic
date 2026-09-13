#Spring_Basic_Week1

## 1. Gradle과 라이브러리

**Gradle**은 프로젝트에서 필요한 라이브러리를 관리하는 빌드 도구.

프로젝트에서 특정 라이브러리를 추가하면 해당 라이브러리가 의존하고 있는 다른 라이브러리도 함께 다운로드하여 사용할 수 있도록 관리.

### 1-1. 스프링 부트 주요 라이브러리

#### (1) `spring-boot-starter-web`

웹 개발에 필요한 라이브러리를 한 번에 사용할 수 있도록 제공.

* `spring-boot-starter-tomcat`: 내장 웹 서버인 Tomcat을 제공.
* `spring-webmvc`: Spring MVC를 이용하여 웹 애플리케이션을 개발할 수 있도록 지원.
* `spring-boot-starter`: Spring Boot와 Spring Core, 로깅 등에 필요한 기본적인 라이브러리를 제공.

#### (2) `spring-boot-starter-thymeleaf`

Thymeleaf 템플릿 엔진을 사용하기 위한 라이브러리.

HTML 파일에 서버에서 전달받은 데이터를 동적으로 적용하여 웹 페이지를 생성할 수 있도록 지원.

---

## 2. View 환경 설정

### 2-1. Welcome Page

Spring Boot는 기본적으로 `static/index.html` 파일을 Welcome Page로 사용할 수 있는 기능을 제공.

---

## 3. Thymeleaf 템플릿 엔진

**Thymeleaf**는 HTML 파일을 기반으로 서버에서 전달받은 데이터를 적용하여 동적인 웹 페이지를 만들어 주는 템플릿 엔진.

Thymeleaf를 사용하면 Controller에서 전달한 데이터를 HTML에서 사용할 수 있음.

### 3-1. Controller 작성

```java
@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }
}
```

* `@Controller`: 해당 클래스를 Spring MVC의 Controller로 등록.
* `@GetMapping("hello")`: `/hello` 주소로 GET 요청이 들어오면 해당 메서드 실행.
* `model.addAttribute("data", "hello!!")`: View에서 사용할 데이터를 Model에 저장.
* `return "hello"`: `hello`라는 이름의 View를 반환.

---

## 4. Thymeleaf HTML 작성

Controller에서 반환한 View 이름에 해당하는 HTML 파일을 다음 위치에 생성함.

```text
src/main/resources/templates/hello.html
```

Controller에서 model.addAttribute("data", "hello!!");와 같이 `data`라는 이름으로 `"hello!!"`를 전달했기 때문에 Thymeleaf에서는 `${data}`를 사용하여 해당 값을 적용할 수 있음.

따라서 최종적으로 웹 페이지에는 안녕하세요. hello!가 출력됨.

---

## 5. Controller와 View의 동작 과정

Controller에서 `return "hello"`를 반환하면 Spring이 해당 이름의 View를 찾아서 처리.

Spring Boot에서 Thymeleaf를 사용할 경우 기본적인 View 이름 매핑은 다음과 같음.

```text
resources/templates/ + {ViewName} + .html
```

따라서 return "hello";를 작성하면
Spring은 다음 파일을 찾게 됨.

```text
src/main/resources/templates/hello.html
```


