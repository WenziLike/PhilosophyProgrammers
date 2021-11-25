<template>
  <header class="header">
    <div class="header__container">
      <div class="header__logo">
        <a href="/">Philosophy <span>Programmer's</span></a>
      </div>
      <nav class="header__menu">
        <router-link :to="{ name: 'writeStory' }">write a story</router-link>
        <router-link :to="{ name: 'home' }">home</router-link>
        <router-link :to="{ name: 'register' }">sign in</router-link>
        <div></div>
        <div class="one"></div>
      </nav>
    </div>
  </header>
</template>

<script>
export default {
  name: "appHeader"
}
</script>

<style lang="scss">

.header {
  position: sticky;
  z-index: 1000;
  width: 100%;
  padding: 10px 40px 10px 20px;

  &__container {
    display: flex;
    justify-content: space-between;
    align-items: center;
    align-self: center;
  }

  &__logo {
    a {
      color: var(--colorText);
      font-weight: 700;
      text-decoration: none;
      font-size: 26px;

      span {
        display: block;
        margin-left: 88px;
        font-size: 18px;
        font-weight: 700;
      }
    }
  }

  &__menu {
    a {
      text-transform: uppercase;
      font-weight: 700;
      text-decoration: none;
      color: var(--colorText);
      width: 120px;
      display: inline-block;
      text-align: center;
      transition: all .33s linear;
      -webkit-transition: all .33s linear;

      &.active {
        color: var(--blueRegular);
      }

      &:nth-child(1) {
        font-size: 12px;
        margin-right: 90px;
      }
    }

    div {
      width: 120px;
      height: 1px;
      background: var(--blueRegular);
    }


    a:nth-child(1) ~ div {
      transition: all .33s linear;
      -webkit-transition: all .33s linear;

    }

    a:nth-child(2):hover ~ div {
      transform: translate(210px);
      -webkit-transform: translate(210px);
      background-color: var(--darkGreen);
      transition: all .33s linear;
      -webkit-transition: all .33s linear;
    }


    a:nth-child(3):hover ~ div {
      transform: translate(210px);
      -webkit-transform: translate(330px);
      background-color: #BF55EC;
      transition: all .33s linear;
      -webkit-transition: all .33s linear;
    }


    a:nth-child(4):hover ~ div {
      transform: translate(210px);
      -webkit-transform: translate(450px);
      background-color: #f39c12;
      color: #03C9A9;
      transition: all .33s linear;
      -webkit-transition: all .33s linear;
    }


    a:nth-child(2):hover {
      //color: #028d0b;
    }

    a:nth-child(3):hover {
      //color: #BF55EC;
    }

    a:nth-child(4):hover {
      //color: #f39c12;
    }
  }
}

</style>