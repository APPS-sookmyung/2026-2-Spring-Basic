## 스프링 부트 프로젝트 기반 생성

1. project
- 빌드도구를 뜻함. 빌드를 도와주는 친구
- Maven이냐 Gradle 이냐
- 빌드란? 소스코드가 실행되기까지의 모든 과정
- Gradle이 가장 최신.
- Gradle - Groovy : 빌드도구랑 대화할 때 Groovy언어로 얘기 ( 가장 자주 씀)
- Gradle - Kotlin: Kotlin언어로 얘기

2. Language
   Java / Kotlin / Groovy

3. Spring boot 버전
- 괄호 있는 것들은 써도 되긴 하는데 오류가 날 수 있다..되도록 선택 x

4. Project Metadata
- Meta: 제 3자 입장에서 나를 바라보는 것 처럼
- 메타 데이터: 프로젝트 밖에서 봤을 때 즉, 껍데기 -> 패키지 이름, 프로젝트이름, 프로젝트 설명..
- Packaging: 프로젝트 다 하고 뭘로 압축할 것인가?
* 배포: 프로젝트가 끝난 다음에 압축해서 실행할 수 있는 형태로 만들기
* Jar : 자바 아카이브의 약자. 자바와 관련된 파일들을 압축해놓음.
  *War: 웹서버 빼고 다른 기본적인 것들, 웹으로 돌아갈 수 있게 할 수 있는 것들은 다 압축을 해서 내보내겠다.

5. Dependencies
   사용할 것 고르는 것


## 프로젝트 기본 구조
- src/main/java : java코드 작성
- src/main/resources : 소스 코드가 아닌 다른 것
- DemoApplication.java : 스프링부트 시작점
- application.properties: 서버 포드 등 환경 설정
- build.gradle: 빌드 및 의존성 관리
