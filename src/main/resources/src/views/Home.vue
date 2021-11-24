<template>
  <div class="home">
    <div class="home__container">
      <div class="home__title">
        <h1>True &</h1>
        <h2>False</h2>
      </div>
      <div class="home__quote">
        <q>If I were asked to choose some modern language <br>to replace Java, I would choose Scala.</q>
        <span>@ James Gosling</span>
      </div>
      <div class="home__cube">
        <div class="box">
          <div class="box-page top"></div>
          <div class="box-page bottom"></div>
          <div class="box-page left"></div>
          <div class="box-page right"></div>
          <div class="box-page before"></div>
          <div class="box-page after"></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src

export default {
  name: 'home'
}
</script>

<style lang="scss">
.home {
  &__container {
  }

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

  &__quote {
    margin-top: 20px;
    text-align: right;
    font-weight: 700;

    q {
      display: block;
      color: #d30000;
      font-size: 18px;
    }

    span {
      margin-right: 30px;
      color: var(--colorText);
      /*====================  LINE TEXT*/
      &:before {
        content: '';
        display: inline-block;
        vertical-align: middle;
        width: 20%;
        height: 0.5px;
        border: .5px solid var(--colorText);
        position: relative;
      }

      &:before {
        /* Ставим левую линию слева от текста, смещая ее на 100% влево */
        margin-left: -100%;
        /* Отступ линии от заголовка */
        left: -14px;
      }
    }
  }

  &__cube {
    perspective: 20000px;
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 50vh;

    .box {
      position: relative;
      z-index: 100000;
      width: 160px;
      height: 160px;
      /* Управляем дочерними элементами для поддержки 3 D-преобразования */
      transform-style: preserve-3d;
      transform: rotateX(45deg) rotateY(45deg);
      animation: ro 26s linear infinite;
      box-shadow: 0 5px 45px rgba(0, 0, 0, 0.25);
    }

    @keyframes ro {
      0% {
        transform: rotateX(0deg) rotateY(0deg);
      }
      100% {
        transform: rotateX(360deg) rotateY(360deg);
      }
    }

    .box-page {
      width: 160px;
      height: 160px;
      /*Инициализация позиции*/

      position: absolute;
      transform-style: preserve-3d;
    }

    .top {
      border: 1px solid var(--colorText);
      transform: rotateX(90deg) translateZ(150px);
      box-shadow: 0 5px 45px rgba(0, 0, 0, 0.25);

      &:hover {
        background-color: rgba(4, 151, 182, 0.80);
        transform: scale(1);

      }
    }

    .bottom {
      border: 1px solid var(--colorText);
      transform: rotateX(-90deg) translateZ(150px);
      box-shadow: 0 5px 45px rgba(0, 0, 0, 0.25);

      &:hover {
        background-color: rgba(2, 141, 11, 0.80);
        transform: scale(1);
      }
    }

    .left {
      border: 1px solid var(--colorText);
      transform: rotateY(90deg) translateZ(150px);
      box-shadow: 0 5px 45px rgba(0, 0, 0, 0.25);

      &:hover {
        background-color: rgba(58, 2, 141, 0.80);
        transform: scale(1);
      }
    }

    .right {
      border: 1px solid var(--colorText);
      transform: rotateY(-90deg) translateZ(150px);
      box-shadow: 0 5px 45px rgba(0, 0, 0, 0.25);

      &:hover {
        background-color: rgba(141, 2, 113, 0.80);
        transform: scale(1);
      }
    }

    .before {
      background-color: rgba(119, 136, 153, 0.60);
      border: 1px solid var(--colorText);
      transform: translateZ(150px);
      box-shadow: 0 5px 45px rgba(0, 0, 0, 0.25);
    }

    .after {
      background-color: rgba(119, 136, 153, 0.60);
      border: 1px solid var(--colorText);
      transform: translateZ(-150px);
      box-shadow: 0 5px 45px rgba(0, 0, 0, 0.25);
    }
  }

}

</style>
