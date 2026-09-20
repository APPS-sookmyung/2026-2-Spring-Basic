#Spring_Basic_Week2

## 1. 스프링 웹 개발 방식

스프링 웹 개발은 크게 3가지 방식으로 나눌 수 있음.

- **정적 컨텐츠**: 파일을 그대로 전달.
- **MVC와 템플릿 엔진**: 서버에서 HTML을 동적으로 만들어 전달.
- **API**: 데이터를 HTTP 응답으로 직접 전달. JSON 타입으로 데이터를 전달.

---

## 2. 정적 컨텐츠

- `resources/static`에 HTML 파일을 생성.
- 별도의 컨트롤러 처리 없이 파일을 그대로 전달.

---

## 3. MVC와 템플릿 엔진

### MVC

- **M (Model)**: 데이터.
- **V (View)**: 화면.
- **C (Controller)**: 비즈니스 로직 및 서버 관련 처리.

### Controller (비즈니스 로직, 서버와 관련)

```java
@Controller
public class HelloController {

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {

        model.addAttribute("name", name);
        return "hello-template";
    }
}
```

### `@GetMapping`

특정 URL 요청을 해당 메서드와 연결.

### `@RequestParam`

URL의 파라미터 값을 받아옴.

```text
/hello-mvc?name=spring
              ↑
           파라미터
```

- 기본값은 `required=true`
- 따라서 해당 파라미터가 없으면 정상적으로 처리되지 않음.

### `Model`

Controller에서 View로 데이터를 전달할 때 사용함.

```java
model.addAttribute("name", name);
```

→ View에서 `name`이라는 이름으로 데이터를 사용할 수 있음.

### `return "hello-template"`

`templates/hello-template.html`을 찾아 화면으로 사용.


### View (화면을 그리는데 집중)

Thymeleaf를 사용하여 Model의 데이터를 HTML에 적용.
변환한 HTML을 client에 넘겨주는 것.

---

## 4. API

API 방식에서는 화면(HTML)을 반환하는 대신 **HTTP 응답 Body에 데이터를 직접 반환**할 수 있음.

### `@ResponseBody`

- 메서드가 반환한 값을 HTML 페이지가 아니라 HTTP 응답의 본문에 직접 넣어서 전달하도록 하는 어노테이션.
- @ResponseBody가 없으면 return "hello"라고 할 때 문자열 자체를 전달이 아니라 hello.html 화면을 찾아서 보여주라는 의미.
- @ResponseBody가 있으면 return "hello"라고 할 때 hello라는 문자열 자체가 브라우저로 전달. (데이터를 직접 반환)


### `@ResponseBody` + 객체 반환

```java
@GetMapping("hello-api")
@ResponseBody
public Hello helloApi(@RequestParam("name") String name) {
    Hello hello = new Hello();
    hello.setName(name);
    return hello;
}
```

`@ResponseBody`를 사용하고 **객체를 반환하면 객체가 JSON으로 변환**됨.

```json
{
  "name": "spring"
}
```

### `@ResponseBody` 동작 원리

`@ResponseBody`를 사용하면 **ViewResolver 대신 `HttpMessageConverter`가 동작**.

- 기본 문자처리 : StringConverter
- 기본 객체처리 : JsonConverter