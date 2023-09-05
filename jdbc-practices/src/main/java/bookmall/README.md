### Model 생성
- `bookmall/main/BookMall.java` 내의 mwb 파일을 통해 Forward Engineering 하시면 테이블이 생성됩니다. 
![image](https://velog.velcdn.com/images/myway00/post/c48a5f91-b809-41f9-8f74-937d990a9a4d/image.PNG)

| 테이블명        | 엔티티          | 속성                                               | 관계                                             |
|-----------------|----------------|----------------------------------------------------|--------------------------------------------------|
| bookmall.Category | Category       | categoryNo (PK), name                               |                                                  |
| bookmall.Member   | Member         | no (PK), name, phone, email, password               |                                                  |
| bookmall.Book     | Book           | no (PK), title, price, categoryNo (FK)             | categoryNo (FK) → Category                      |
| bookmall.Orders   | Orders         | no (PK), orderNo, price, address, memberNo (FK), memberName | memberNo (FK) → Member                          |
| bookmall.OrderBook| OrderBook      | bookNo (FK), orderNo (FK), bookTitle, bookPrice, quantity | bookNo (FK) → Book, orderNo (FK) → Orders    |
| bookmall.Cart     | Cart           | bookNo (FK), memberNo (FK), quantity, memberName, bookTitle, price | bookNo (FK) → Book, memberNo (FK) → Member |

### 실행 방법 
- `bookmall/main/BookMall.java` 내의 main 함수를 실행시켜주시면 됩니다.

### 결과 화면
``` 

## 회원리스트
회원정보      [이름=myway00, 전화번호=010-1234-5678, 이메일=myway00@mail.com]
회원정보      [이름=kickscar, 전화번호=010-0011-0011, 이메일=kickscar@mail.com]

## 카테고리
카테고리 리스트 [카테고리번호=1, 카테고리이름=요리]
카테고리 리스트 [카테고리번호=2, 카테고리이름=여행]
카테고리 리스트 [카테고리번호=3, 카테고리이름=판타지 소설]

## 도서 상품
책 리스트     [책 번호=1, 책 제목=베이킹 책, 가격 =10000, 카테고리 번호 =1]
책 리스트     [책 번호=2, 책 제목=스위스 여행 일대기, 가격 =20000, 카테고리 번호 =2]
책 리스트     [책 번호=3, 책 제목=해리포터, 가격 =30000, 카테고리 번호 =3]

## 카트
카트 리스트    [주문자=myway00, 책 제목=베이킹 책, 가격=10000, 수량=1]
카트 리스트    [주문자=kickscar, 책 제목=스위스 여행 일대기, 가격=20000, 수량=1]

## 주문
주문 리스트    [주문번호=1, 주문자=myway00, 총 금액=10000, 주소=서울 ]

## 주문도서
주문 도서 리스트 [책 번호=1, 책 제목=베이킹 책, 가격=10000, 수량 =1, 주문번호=0]
주문 도서 리스트 [책 번호=2, 책 제목=스위스 여행 일대기, 가격=20000, 수량 =1, 주문번호=0]

Process finished with exit code 0

```

### Connection 오류 발생할 시에 수정할 변수 
- `bookmall/common/JdbcVar.java` 에서 적절하게 Connection URL 과 USER, PASSWORD 를 변경해주시면 됩니다.
- 과제에서 주어진 사항에서 USER , PASSWORD 를 `bookmall` 로 하라고 전달받아 그렇게 설정해두었습니다. 
``` 
    public static final String URL = "jdbc:mariadb://192.168.%:3307/bookmall?charset=utf8";
    public static final String USER = "bookmall";
    public static final String PASSWORD = "bookmall";
    public static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver"; 
```