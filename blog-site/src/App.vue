<template>
  <div id="app">
    <NavBar></NavBar>
    <div class="jumbotron"><!--JumboTron-->
      <h1 id="headline"><strong></strong></h1>
    </div><!--JumboTron-->
    <b-container fluid>
      <b-row>
        <b-col sm="2">
          <SideBar></SideBar>
        </b-col>
        <b-col sm="10">
          <router-view/>
        </b-col>
      </b-row>
    </b-container>
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
