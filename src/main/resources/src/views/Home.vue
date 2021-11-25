<template>
  <div class="home">

    <div class="home__container">
      <div class="home__title">
        <h1>True &</h1>
        <h2>False</h2>
      </div>

      <Cube/>

      <a href="/articles">
        <icon name="arrow-down"></icon>
      </a>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
import Icon from "@/components/svg/icon";
import Cube from "@/components/Cube";

export default {
  name: 'home',
  components: {Cube, Icon}
}
</script>

<style lang="scss">
.home {
  &__title {
    h1, h2 {
      position: absolute;
    }

    h1 {
      font-size: 100px;
      left: 8%;
      bottom: 20%;
      color: transparent;
      -webkit-text-stroke: 2px var(--colorText);
      text-stroke: 1px white;
    }

    h2 {
      left: 14%;
      bottom: 16%;
      font-family: 'Libre Baskerville', serif;
      font-size: 70px;
    }
  }

  /* arrow - down*/
  &__arrow-down {
    position: fixed;
    bottom: 10%;
    border-radius: 100%;
    color: var(--colorText);
    border: 1px solid var(--colorText);
    transform: rotateX(180deg);
    cursor: pointer;

    &:hover {
      color: var(--darkBlue);
      border: 1px solid var(--blueRegular);
    }
  }
}
</style>


<!--      <div class="home__quote">-->
<!--        <q>If I were asked to choose some modern language <br>to replace Java, I would choose Scala.</q>-->
<!--        <span>@ James Gosling</span>-->
<!--      </div>-->
