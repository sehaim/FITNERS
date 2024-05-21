<template>
  <div id="home-container">
    <div id="img-container">
      <img src="@/assets/img/home-image.jpg" alt="home-image" />
    </div>
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
