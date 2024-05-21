<template>
  <div id="full-container">
    <TheHeaderNav id="header" />
    <RouterView id="content" />
    <TheFooterNav id="footer" />
  </div>
</template>

<script setup>
import TheHeaderNav from "@/components/common/TheHeaderNav.vue";
import TheFooterNav from "@/components/common/TheFooterNav.vue";
</script>

<style scoped>
#full-container {
  display: flex;
  flex-direction: column;
  min-height: 100%;
  height: 100vh;
  position: relative;
}

#header {
  z-index: 100;
}

#footer {
  position: relative;
  transform: translatY(-100%);
  bottom: 0;
  margin-top: auto;
  z-index: 100;
}
</style>
