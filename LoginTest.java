package jyplord.calender;


import jyplord.calender.Entity.UserEntity;
import org.junit.jupiter.api.*;
import org.springframework.mock.web.MockHttpSession;

public class LoginTest {

    MockHttpSession sessionTest = new MockHttpSession();

    UserEntity user = new UserEntity("박준우", "19990206", "jygoldn@naver.com", "a1234");


    @Nested
    class IsSessionReal {

        @BeforeEach
        @DisplayName("세션 생성하기")
        void authenticateSession() {

            sessionTest.setAttribute("LoginUser", user);
        }

        @Test
        @DisplayName("세션 진짜 만들어진거 맞음?")
        void IsSessionRealExist() {
            Object a = sessionTest.getAttribute("LoginUser");
            System.out.println(a);
        }

        @AfterEach
        @DisplayName("세션 없애기~")
        void testExit() {
            sessionTest.invalidate();
        }
    }

    //When
    @Nested
    class IsSessionReallyInvalidate {
        @Test
        void sessionInvalidateTest(){
            sessionTest.getAttribute("LogInUser");
        }
    }
}
