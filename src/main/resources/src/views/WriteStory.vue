<template>
  <div class="new__article">
    <h1> ...Write your article</h1>
    <div class="new__article-container">
      <form action="#">

        <label>
          <span>Hash Tags</span>
          <input type="text"/>
        </label>
        <label>
          <span>Title</span>
          <input type="text"/>
        </label>
        <label class="cursor">
          <span>Text</span>
          <textarea class="form-control" rows="10" cols="90"
                    placeholder="Write..." th:field="*{body}"></textarea>
          <i></i>
        </label>

        <button type="submit" class="button" @click.prevent="buttonText = !buttonText">{{ btnText }}</button>
      </form>
    </div>
  </div>

</template>

<script>
export default {
  name: "writeStory",
  data() {
    return {
      buttonText: false
    }
  },
  computed: {
    btnText() {
      if (this.buttonText) {
        return 'Thank You!!!'
      }
      return 'Send Post'
    }
  }

}
</script>

<style lang="scss">

.new__article {
  input,
  button, textarea {
    border: none;
    outline: none;
    background: none;
  }

  h1 {
    margin-right: 90px;
    text-align: right;
  }

  &-container {
    display: flex;

    form {
      display: block;
      margin: 0 auto;

      label {
        display: block;
        width: 600px;
        margin: 20px auto 0;
        text-align: center;
      }

      label span {
        font-size: 14px;
        color: #b9b9b9;
        text-transform: uppercase;
      }

      input, textarea {
        display: block;
        width: 100%;
        margin-top: 5px;
        padding-bottom: 5px;
        font-size: 16px;
        color: #495A72;
        font-weight: 900;
        border-bottom: solid 1px lightslategray;
      }

      textarea {
        padding: 20px;
        border-radius: 4px;
        border: solid 1px lightslategray;
        resize: none;
        -webkit-box-shadow: -5px -5px 5px -5px rgba(34, 60, 80, 0.6);
        -moz-box-shadow: -5px -5px 5px -5px rgba(34, 60, 80, 0.6);
        box-shadow: -5px -5px 5px -5px rgba(34, 60, 80, 0.6);
      }

      /*======================= Blink Cursor */
      .cursor {
        position: relative;
      }

      .cursor i {
        position: absolute;
        width: 5px;
        height: 10%;
        background-color: #028d0b;
        left: 100px;
        top: 18%;
        animation-name: blink;
        animation-duration: 800ms;
        animation-iteration-count: infinite;
        opacity: 1;
      }

      .cursor textarea:focus + i {
        display: none;
      }

      @keyframes blink {
        from {
          opacity: 1;
        }
        to {
          opacity: 0;
        }
      }
      /*=======================*/

      button {
        display: block;
        margin: 20px auto 0;
      }

      svg {
        width: 100%;
        height: 100%;
      }

      path {
        stroke-dasharray: 99.47578430175781;
        stroke-dashoffset: -99.47578430175781;
        fill: transparent;
      }

      svg.animate path {
        animation: 1.7s ease forwards draw;
        opacity: 1;
      }

      @keyframes draw {
        0% {
          opacity: 1;
          stroke-dashoffset: -99.47578430175781;
          fill: transparent;
          transform: translateY(0);
        }

        35% {
          stroke-dashoffset: 0;
          fill: transparent;
        }

        60% {
          fill: #80bdff;
          opacity: 1;
          transform: translateY(0);
        }

        100% {
          fill: #0b76ef;
          stroke-dashoffset: 0;
          opacity: 0;
          transform: translateY(-10px);
        }
      }


      button {
        cursor: pointer;
        min-width: 200px;
        padding: 15px 5px;
        text-transform: uppercase;
        vertical-align: middle;
        background: #0b76ef;
        border: none;
        color: #ffffff;
        font-weight: 600;
        border-radius: 5px;
        box-shadow: 0 0 10px #009EE3FF;
        transition: all 1s;
      }

      button:hover {
        box-shadow: 0 0 25px #009EE3FF;
      }

      button:focus {
        outline: none;
      }

    }

    .tools {
    }
  }
}
</style>