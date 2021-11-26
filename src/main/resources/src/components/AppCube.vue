<template>
  <div class="cube">
    <div class="box">
      <div class="box-page top"></div>
      <div class="box-page bottom"></div>
      <div class="box-page left"></div>
      <div class="box-page right"></div>
      <div class="box-page before"></div>
      <div class="box-page after"></div>
    </div>
  </div>
</template>

<script>
export default {
  name: "cube"
}
</script>

<style lang="scss" scoped>
.cube {
  perspective: 20000px;
  position: relative;
  margin-top: 200px;
  left: 70%;
  bottom: 50%;

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
</style>