# 스프링 MVC 기본 기능 학습

(참고 : 새롭게 알게 된 것들만 정리!)

### 1. 로깅

- `private final Logger logger = LoggerFactory.getLogger(LogTestController.class);`-> `@Slf4j`
- `logging.level.hello.springmvc=debug` 에서 패키지별 로그 레벨 설정 가능

### 2. RequestMapping

- url에 중괄호({}) 로 넘어오는 변수들 (`@GetMapping("/mapping/{userId}")`)
  - PathVariable 사용 
  - 변수 명이 같으면 생략 가능 
    - `@PathVariable("userId") String userId` -> `@PathVariable userId`
- 특정 파라미터, 특정 헤더, 특정 미디어 타입 조건을 만족시켰을 때 호출되도록 할 수 있다.
  - `@GetMapping(value = "/mapping-param", params = "mode=debug")`
  - `@GetMapping(value = "/mapping-header", headers = "mode=debug")`
  - `@PostMapping(value = "/mapping-consume", consumes = "application/json")` -> Content-Type 헤더 기반
  - `@PostMapping(value = "/mapping-produce", produces = "text/html")` -> Accept 헤더 기반 Media Type

### 3. HTTP 요청 파라미터
- `@RequestParam`
  - 파라미터 이름으로 바인딩
- `@ModelAttribute`
  - `@ModelAttribute`의 동작 순서 (예시 : `@ModelAttribute Member member`)
    1. `Member` 객체를 생성한다.
    2. 요청 파라미터의 이름으로 `Member` 객체의 프로퍼티를 찾는다.
    3. 해당 프로퍼티의 setter를 호출해서 파라미터의 값을 입력(바인딩) 한다.
       - 프로퍼티 : 객체에 `getName()` , `setName()` 메서드가 있으면, 이 객체는 `name` 이라는 프로퍼티를 가지고 있다.
       - 예) 파라미터 이름이 `name` 이면 `setName()` 메서드를 찾아서 호출하면서 값을 입력한다.

- `@RequestParam`, `@ModelAttribute` 모두 생락 가능하다.
  - 스프링은 해당 생략시 다음과 같은 규칙을 적용한다.
  - `String` , `int` , `Integer` 같은 단순 타입 = `@RequestParam`
  - 나머지 = `@ModelAttribute` (argument resolver 로 지정해둔 타입 외)
    - argument resolver 로 지정해둔 타입 예 : `HttpServletResponse`
