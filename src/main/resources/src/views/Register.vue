<template>
  <div class="authorize">
    <!--=======  Login-->
    <form class="form sign-in">

      <h2 class="title">Welcome back !!!</h2>

      <label>
        <span>E-mail</span>
        <input type="email"/>
      </label>
      <label>
        <span>Password</span>
        <input type="password"/>
      </label>

      <icon name="icon-show-pass" class="icon-show-pass icon__show-pass"></icon>
      <div class="block">
        <!--=========  REMEMBER ME-->
        <div class="check">
          <input type="checkbox" id="remember" class="custom-checkbox agreeTerms" name="remember-me">
          <label for="remember">
            Remember Me
          </label>
        </div>

        <a href="#" class="forgot-pass">Forgot password?</a>
      </div>

      <button type="button" class="submit">Sign In</button>
      <button type="button" class="fb-btn">Connect with <span>facebook</span></button>
    </form>

    <div class="sub-container">
      <div class="img">
        <div class="img__text m--up">
          <h2>New here?</h2>
          <p>Sign up and discover great amount of new opportunities!</p>
        </div>
        <div class="img__text m--in">
          <h2>One of us?</h2>
          <p>If you already has an account, just sign in. We've missed you!</p>
        </div>
        <div class="img__btn" @click="authorize">
          <span class="m--up">Sign Up</span>
          <span class="m--in">Sign In</span>
        </div>
      </div>

      <!--=======  REGISTRATION-->
      <form class="form sign-up">
        <h2 class="title">Time to feel like home</h2>
        <div class="grid">
          <label>
            <span>First Name</span>
            <input type="text"/>
          </label>
          <label>
            <span>Last Name</span>
            <input type="text"/>
          </label>
          <label>
            <span>Username</span>
            <input type="text"/>
          </label>

          <label>
            <span>Email</span>
            <input type="email"/>
          </label>
          <label>
            <span>Password</span>
            <input type="password"/>
          </label>
          <label>
            <span>Retype password</span>
            <input type="password"/>
          </label>
        </div>
        <icon name="icon-show-pass" class="icon-show-pass"></icon>
        <div class="block">
          <!--=========  agreeTerms -->
          <div class="check">
            <input type="checkbox" id="agreeTerms" class="custom-checkbox agreeTerms" name="terms" value="agree">
            <label for="agreeTerms">
              I agree to the <a href="#"><span>terms</span></a>
            </label>
          </div>
        </div>

        <button type="button" class="submit">Sign Up</button>
        <button type="button" class="fb-btn">Join with <span> facebook</span></button>
      </form>
    </div>
  </div>
</template>

<script>
import Icon from "@/components/svg/icon";

export default {
  name: "register",
  components: {Icon},
  data() {
    return {}
  },
  methods: {
    authorize() {
      const imgBtn = document.querySelector('.img__btn')
      const form = document.querySelector('.authorize')
      imgBtn.addEventListener('click', function () {
        form.classList.toggle('s--signup')
      })
    }
  }
}
</script>

<style lang="scss" scoped>

input,
button {
  border: none;
  outline: none;
  background: none;
}

.authorize {
  position: relative;
  overflow: hidden;
  margin: 5px auto;
  border-radius: 6px;
  width: 900px;
  height: 550px;
  background: var(--white);
  box-shadow: 0 5px 45px rgba(0, 0, 0, 0.25);
}

.form {
  position: relative;
  width: 640px;
  height: 100%;
  -webkit-transition: -webkit-transform 1.2s ease-in-out;
  transition: -webkit-transform 1.2s ease-in-out;
  transition: transform 1.2s ease-in-out;
  transition: transform 1.2s ease-in-out, -webkit-transform 1.2s ease-in-out;
  padding: 50px 30px 0;

  /* =============== SVG Icons Password*/
  .icon-show-pass {
    position: relative;
    left: 12px;
    top: -30px;
    cursor: pointer;
    color: var(--colorText);
  }

  .icon__show-pass {
    position: relative;
    margin-left: 386px;
    top: -30px;
  }
}

.sub-container {
  overflow: hidden;
  position: absolute;
  left: 640px;
  top: 0;
  width: 900px;
  height: 100%;
  padding-left: 260px;
  background: var(--white);
  -webkit-transition: -webkit-transform 1.2s ease-in-out;
  transition: -webkit-transform 1.2s ease-in-out;
  transition: transform 1.2s ease-in-out;
  transition: transform 1.2s ease-in-out, -webkit-transform 1.2s ease-in-out;
}

.authorize.s--signup .sub-container {
  -webkit-transform: translate3d(-640px, 0, 0);
  transform: translate3d(-640px, 0, 0);
}

button {
  display: block;
  margin: 0 auto;
  width: 240px;
  height: 36px;
  border-radius: 30px;
  color: var(--white);
  font-size: 15px;
  cursor: pointer;
}

.img {
  overflow: hidden;
  z-index: 2;
  position: absolute;
  left: 0;
  top: 0;
  width: 260px;
  height: 100%;
  padding-top: 360px;
}

.img:before {
  content: '';
  position: absolute;
  right: 0;
  top: 0;
  width: 400px;
  height: 100%;
  background-image: url("../assets/img/login.jpg");
  opacity: .8;
  background-size: cover;
  -webkit-transition: -webkit-transform 1.2s ease-in-out;
  transition: transform 1.2s ease-in-out;
  transition: transform 1.2s ease-in-out, -webkit-transform 1.2s ease-in-out;
}

.img:after {
  content: '';
  position: absolute;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.6);
}

.authorize.s--signup .img:before {
  -webkit-transform: translate3d(640px, 0, 0);
  transform: translate3d(640px, 0, 0);
}

.img__text {
  z-index: 2;
  position: absolute;
  left: 0;
  top: 50px;
  width: 100%;
  padding: 0 20px;
  text-align: center;
  color: var(--white);
  -webkit-transition: -webkit-transform 1.2s ease-in-out;
  transition: -webkit-transform 1.2s ease-in-out;
  transition: transform 1.2s ease-in-out;
  transition: transform 1.2s ease-in-out, -webkit-transform 1.2s ease-in-out;
}

.img__text h2 {
  margin-bottom: 10px;
  font-weight: normal;
}

.img__text p {
  font-size: 14px;
  line-height: 1.5;
}

.authorize.s--signup .img__text.m--up {
  -webkit-transform: translateX(520px);
  transform: translateX(520px);
}

.img__text.m--in {
  -webkit-transform: translateX(-520px);
  transform: translateX(-520px);
}

.authorize.s--signup .img__text.m--in {
  -webkit-transform: translateX(0);
  transform: translateX(0);
}

.img__btn {
  overflow: hidden;
  z-index: 2;
  position: relative;
  width: 100px;
  height: 36px;
  margin: 0 auto;
  background: transparent;
  color: var(--white);
  text-transform: uppercase;
  font-size: 15px;
  cursor: pointer;

  &:hover {
    color: var(--blueRegular);
  }
}

.img__btn:after {
  content: '';
  z-index: 2;
  position: absolute;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  border: 1px solid var(--white);
  border-radius: 30px;
}

.img__btn span {
  position: absolute;
  left: 0;
  top: 0;
  display: -webkit-box;
  display: flex;
  -webkit-box-pack: center;
  justify-content: center;
  -webkit-box-align: center;
  align-items: center;
  width: 100%;
  height: 100%;
  -webkit-transition: -webkit-transform 1.2s;
  transition: -webkit-transform 1.2s;
  transition: transform 1.2s;
  transition: transform 1.2s, -webkit-transform 1.2s;
}

.img__btn span.m--in {
  -webkit-transform: translateY(-72px);
  transform: translateY(-72px);
}

.authorize.s--signup .img__btn span.m--in {
  -webkit-transform: translateY(0);
  transform: translateY(0);
}

.authorize.s--signup .img__btn span.m--up {
  -webkit-transform: translateY(72px);
  transform: translateY(72px);
}

h2.title {
  width: 100%;
  font-size: 26px;
  text-align: center;
  font-family: 'Libre Baskerville', serif;
  font-weight: 500;
}

label {
  display: block;
  width: 260px;
  margin: 20px auto 0;
  text-align: center;
}

label span {
  font-size: 14px;
  color: #b9b9b9;
  text-transform: uppercase;
}

input {
  display: block;
  width: 100%;
  margin-top: 5px;
  padding-bottom: 5px;
  font-size: 16px;
  text-align: center;
  color: #495A72;
  font-weight: 900;
  border-bottom: solid 1px lightslategray;
}

.submit {
  margin-top: 30px;
  margin-bottom: 20px;
  font-weight: 700;
  font-size: 16px;
  letter-spacing: .6px;
  background-color: var(--white);
  color: #495A72;
  border-radius: 60px;
  border: 1px solid #495A72;
  cursor: pointer;

  &:hover {
    background-color: #495A72;
    color: var(--white);
  }
}

.fb-btn {
  color: #8fa1c7;

  span {
    margin-left: 6px;
    font-weight: 900;
    color: var(--blueRegular);
    text-decoration: underline;

    &:hover {
      text-decoration: none;
    }
  }
}

.sign-in {
  -webkit-transition-timing-function: ease-out;
  transition-timing-function: ease-out;
}

.authorize.s--signup .sign-in {
  -webkit-transition-timing-function: ease-in-out;
  transition-timing-function: ease-in-out;
  -webkit-transition-duration: 1.2s;
  transition-duration: 1.2s;
  -webkit-transform: translate3d(640px, 0, 0);
  transform: translate3d(640px, 0, 0);
}

.sign-up {
  -webkit-transform: translate3d(-900px, 0, 0);
  transform: translate3d(-900px, 0, 0);
  .grid{
    display: grid;
    grid-template-columns: repeat(2, 1fr);
    margin-top: 5px
  }
}

.authorize.s--signup .sign-up {
  -webkit-transform: translate3d(0, 0, 0);
  transform: translate3d(0, 0, 0);
}

/* =============== Checkbox*/
.block {
  position: relative;
  text-align: center;

  .forgot-pass {
    text-align: center;
    color: #495A72;
  }

  .agreeTerms {
    opacity: 0;
    cursor: pointer;
  }

  label {
    margin-top: 0;

    a {
      text-decoration: none;
      margin-left: 8px;
      color: var(--blueRegular);

      span {
        color: var(--darkGreen);
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
    justify-content: center;
    align-items: center;
    user-select: none;
    cursor: pointer;
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
    border-color: var(--blueRegular);
    background-color: var(--blueRegular);
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

</style>