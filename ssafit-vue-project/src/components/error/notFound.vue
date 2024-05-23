<template>
  <div id="not-found-container">
    <img src="@/assets/img/sad-icon.png" alt="sad-icon" />
    <div id="text">잘못된 접근입니다!</div>
  </div>
</template>

<style scoped>
#not-found-container {
  width: 500px;
  height: 500px;
  margin: auto;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-250px, -250px);
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-between;
  padding: 180px 0;
}

img {
  width: 70px;
  opacity: 70%;
}

#text {
  font-size: 20px;
}
</style>
