<template>
  <div id="home-container">
    <div id="img-container">
      <img src="@/assets/img/home-image.jpg" alt="home-image" />
    </div>
    <div id="banner">Let's work out with us!</div>
    <HomeHotBoardList />
  </div>
</template>

<script setup>
import HomeHotBoardList from "@/components/home/HomeHotBoardList.vue";
</script>

<style scoped>
#home-container {
  min-height: 80vh;
  height: 80vh;
}

#img-container {
  position: relative;
  display: inline-block;
  width: 100%;
  height: 100%;
}

@keyframes typing {
  from {
    width: 0;
  }
  to {
    width: 100%;
  }
}

/* 커서 깜빡임 */
@keyframes blink {
  50% {
    border-color: transparent;
  }
}

#banner {
  max-width: 740px;
  height: 55px;
  position: absolute;
  top: 20%;
  right: 8%;
  z-index: 100;
  font-family: "neodgm";
  font-size: 50px;
  color: rgb(233, 199, 86);
  text-shadow: -4px 0px rgb(0, 0, 0), 0px 4px rgb(0, 0, 0),
    0px -2px rgb(0, 0, 0), 2px 0px rgb(0, 0, 0);
  overflow: hidden;
  border-right: 0.1em solid rgb(233, 199, 86);
  white-space: nowrap;
  margin: 0 auto;
  letter-spacing: 0.15em;
  animation: typing 3s steps(30, end), blink 0.75s step-end infinite;
}

#banner::after {
  content: "|";
  display: inline-block;
  animation: blink 0.75s step-end infinite;
}

#img-container::before {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: linear-gradient(
    to bottom,
    rgba(255, 255, 255, 0) 0%,
    rgba(255, 255, 255, 0.03) 20%,
    rgba(255, 255, 255, 0.035) 40%,
    rgba(255, 255, 255, 0.7) 60%,
    rgba(255, 255, 255, 0.9) 65%,
    rgba(255, 255, 255, 1) 70%,
    rgba(255, 255, 255, 1) 80%,
    rgba(255, 255, 255, 1) 100%
  );
  z-index: 1;
}

img {
  width: 100%;
  height: 100%;
  opacity: 85%;
}
</style>
