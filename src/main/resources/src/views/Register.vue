<template>
  <div class="register">
    <div class="register__container">
      <div class="register__left">
        <div class="register__profile">
          New to profile?
          <strong>Create an account.</strong>
          <a href="/register"><span>Sign In</span></a>
        </div>
        <img src="../assets/img/registration.jpg" alt="background registration">
      </div>
      <div class="register__right">
        <div class="register__header">
          <div class="title">
            <h1>Registration</h1>
          </div>
        </div>
        <div class="register__body">
          <form class="" th:action="@{/register}"
                th:object="${userDTO}"
                method="post">

            <div class="alert alert-danger" th:if="${#fields.hasErrors('*')}">
              <p th:each="err : ${#fields.errors('*')}" th:text="${err}"></p>
            </div>

            <div class="form__container">
              <div class="form__box">
                <label for="firstName">First Name</label>
                <input type="text" class="form__control" id="firstName" th:field="*{firstName}">
              </div>

              <div class="form__box">
                <label for="lastName">Last Name</label>
                <input type="text" class="form__control" id="lastName" th:field="*{lastName}">
              </div>

              <div class="form__box">
                <label for="username">Username</label>
                <input type="text" class="form__control" id="username" th:field="*{username}">
              </div>

              <div class="form__box">
                <label for="email">E-mail</label>
                <input type="email" class="form__control" id="email" th:field="*{email}">
              </div>

              <div class="form__box">
                <label for="password">Password</label>
                <input type="password" class="form__control" id="password" th:field="*{password}">
              </div>

              <div class="form__box">
                <label for="retypePassword">Retype password</label>
                <input type="password" class="form__control" id="retypePassword" th:field="*{confirmPassword}">
              </div>

            </div>
            <icon name="disabledPassword" class="disabledPassword"></icon>
          </form>

          <div class="button_box">
            <button type="submit" class="button">sign up</button>
          </div>

        </div>
        <div class="register__footer">
          <div class="check">
            <input type="checkbox" id="agreeTerms" class="agreeTerms custom-checkbox" name="terms" value="agree">
            <label for="agreeTerms">
              I agree to the <a href="#"><span>terms</span></a>
            </label>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Icon from "@/components/svg/icon";

export default {
  name: "Register",
  components: {Icon}
}
</script>

<style lang="scss">

.register {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;

  &__container {
    display: flex;
    box-shadow: 29px 17px 24px -5px #5e5e5e;
  }

  &__profile {
    position: absolute;
    z-index: 1;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    font-size: 18px;
    font-weight: 700;
    color: white;

    strong {
      font-size: 16px;
    }

    a {
      display: block;
      margin-top: 16px;
      padding: 6px 10px;
      //border: 1px solid #0b76ef;
      //border-radius: 60px;
      text-decoration: none;
      color: white;

      span {
        color: #0b76ef;
        font-size: 26px;
      }

      &:hover {
        //background-color: white;
        text-decoration: underline;
      }
    }
  }

  /* =============== SVG Icons*/
  .disabledPassword {
    position: absolute;
    top: 73%;
    right: 54%;
    transform: translate(-50%, -50%);
    width: 32px;
    height: 32px;
    cursor: pointer;
  }

  &__left {
    position: relative;

    img {
      filter: brightness(40%);
      max-width: 300px;
      height: 100%;
      border-top-left-radius: 4px;
      border-bottom-left-radius: 4px;
    }
  }

  &__right {
    border-top-right-radius: 4px;
    border-bottom-right-radius: 4px;
    background-color: white;
  }

  &__header {
    font-family: 'Libre Baskerville', serif;
    padding: 60px 160px 40px;

    .title h1 {
      font-weight: 500;
      text-transform: uppercase;
    }
  }

  &__body {
    .form__container {
      display: grid;
      position: relative;
      grid-template-columns: repeat(auto-fill, minmax(280px, 280px));
      grid-column-gap: 18px;
      grid-row-gap: 20px;
      justify-content: center;
    }

    label {
      display: block;
      font-size: 16px;
      font-weight: 600;
      color: #495A72;
    }

    .form__control {
      color: #495A72;
      width: 250px;
      margin-top: 10px;
      font-size: 16px;
      font-weight: 900;
      outline: none;
      border: none;
      border-bottom: solid 1px lightslategray;
    }

    .button {
      margin-top: 20px;
      padding: 4px 30px;
      font-weight: 700;
      font-size: 16px;
      letter-spacing: .6px;
      background-color: white;
      color: #495A72;
      border-radius: 60px;
      border: 1px solid #495A72;
      cursor: pointer;

      &:hover {
        background-color: #495A72;
        color: white;
      }

      &:active {
        box-shadow: none;
      }
    }
  }

  &__footer {
    padding-top: 20px;

    .check {
      position: relative;
    }

    .agreeTerms {
      display: inline-block;
      position: absolute;
      z-index: -1;
      top: 50%;
      left: 36%;
      transform: translate(-50%, -50%);
      opacity: 0;
      cursor: pointer;
    }

    label {
      a {
        text-decoration: none;
        margin-left: 8px;
        color: #0b76ef;

        span {
          font-weight: 900;
          font-size: 14px;
        }

        &:hover {
          text-decoration: underline;
        }
      }
    }

    .custom-checkbox + label {
      display: inline-flex;
      align-items: center;
      user-select: none;
    }

    .custom-checkbox + label::before {
      content: '';
      display: inline-block;
      width: 1em;
      height: 1em;
      flex-shrink: 0;
      flex-grow: 0;
      border: 1px solid #adb5bd;
      border-radius: 0.25em;
      margin-right: 1em;
      background-repeat: no-repeat;
      background-position: center center;
      background-size: 50% 50%;
    }

    .custom-checkbox:checked + label::before {
      border-color: #0b76ef;
      background-color: #0b76ef;
      background-image: url("data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 8 8'%3e%3cpath fill='%23fff' d='M6.564.75l-3.59 3.612-1.538-1.55L0 4.26 2.974 7.25 8 2.193z'/%3e%3c/svg%3e");
    }

    /* стили при наведении курсора на checkbox */
    .custom-checkbox:not(:disabled):not(:checked) + label:hover::before {
      border-color: #b3d7ff;
    }

    /* стили для активного состояния чекбокса (при нажатии на него) */
    .custom-checkbox:not(:disabled):active + label::before {
      background-color: #b3d7ff;
      border-color: #b3d7ff;
    }

    /* стили для чекбокса, находящегося в фокусе */
    .custom-checkbox:focus + label::before {
      box-shadow: 0 0 0 0.2rem rgba(0, 123, 255, 0.25);
    }

    /* стили для чекбокса, находящегося в фокусе и не находящегося в состоянии checked */
    .custom-checkbox:focus:not(:checked) + label::before {
      border-color: #80bdff;
    }
  }
}

</style>