<template>
  <AppHeader/>
  <div class="container">
    <router-view></router-view>
  </div>
</template>

<style lang="scss">
@import url('https://fonts.googleapis.com/css2?family=Libre+Baskerville&display=swap');

*, *::before,
*::after {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}

/* Theme colors*/
:root {
  --black: #333;
  --black2: #333;
  --white: #fff;
  --white2: #fff;
  --darkBlue: #2c3e50;
  --bgCursor: #028d0b;
  --darkGreen: #028d0b;
  --blueRegular: #0b76ef;
  --colorText: #778899FF;
  --darkRed: #8d0000;
}

body {
  font-family: 'Montserrat', sans-serif;
  background-color: #F0F2F5;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: var(--darkBlue);

  .container {
    max-width: 1200px;
    margin: 0 auto;
  }
}
</style>
<script>
import AppHeader from "@/components/AppHeader";

export default {
  components: {AppHeader}
}
</script>