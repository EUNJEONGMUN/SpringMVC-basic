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