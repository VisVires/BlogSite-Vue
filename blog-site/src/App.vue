<template>
  <div id="app">
    <NavBar></NavBar>
    <div id="nav">
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link>
    </div>
    <router-view/>
    <SideBar></SideBar>
    <Footer></Footer>
  </div>
</template>

<script>

import NavBar from '@/components/NavBar.vue'
import SideBar from '@/components/SideBar.vue'
import Footer from '@/components/Footer.vue'

export default {
  name: 'App',
  components: {
    SideBar,
    NavBar,
    Footer
  }
}
</script>
