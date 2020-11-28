# ehcache
##### * 개발 환경
- mac os catalina
- java 15
- spring boot 2.4.0
- gradle 6.6.1

##### # ehcache린?
- 캐시 시스템
- 업데이트가 필요없는 데이터를 메모리에 캐싱하여 서버요청 없이 데이터를 로딩하여, 서버 부담을 줄어주고 빠른 응답을 제공
- spring 에서 제공 하고 있어 빠른 캐싱 시스템 구축 가능

##### # API 소개
- API : /cache
- 파라미터
1. cacheMode : 캐시 모드
-> add : 캐싱이 안되어 있다면 캐싱, 캐싱이 되어 있다면 캐싱을 하지 않는다.
-> update : 캐싱을 무조건 한다.
-> delete : 해당하는 키만 캐싱을 제거한다.
-> alldelete : 모든 캐싱을 제거한다.
2. key : 캐싱 메세지의 키값
- 키값에 따라 캐싱을 하므로 유니크 하다.
3. context : 캐싱 데이터
- 응답
1. 캐싱된 데이터 리턴
2. 캐싱 메소드가 실행 됐다면 로그를 남긴다.