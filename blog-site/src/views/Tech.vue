<template>
  <div class="tech">
    <div class="blog-header">
      <h1 style="text-align: left" class="blog-title">
      <strong>TECH_BLOG</strong></h1>
      <p class="lead blog-description"></p>
    </div>
    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-8">
          <Quote></Quote>
          <hr>
          <div id="techblog-post" v-if="posts.length">
            <TechBlog :currPost="currPost"></TechBlog>
            <b-button-group>
              <b-button size="lg" variant="outline-secondary" type="button" @click="prevPage" :disabled="currentPage==0">Prev Post</b-button>
              <b-button size="lg" variant="outline-secondary" type="button" @click="nextPage" :disabled="currentPage >= pages-1">Next Post</b-button>
            </b-button-group>
            <hr>
          </div>
          <div v-else>
            <h5>Sorry! There seems to be an issue, hit the email button below and let me know!</h5>
          </div>
        </div>
        <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
          <div class="sidebar-module sidebar-module-inset">
            <h4>About</h4>
              <p>The purpose of this blog is to both give the reader a window into <em>what I'm learning right now</em> and specific topics that interest me in the broad world of Computer Science</p>
          </div>
          <div class="sidebar-module">
          </div>
          <div class="sidebar-module">
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import Quote from '@/components/Quote.vue'
import TechBlog from '@/components/TechBlog.vue'
import axios from 'axios'

export default {
  name: 'Tech',
  components: {
    Quote,
    TechBlog
  },
  data () {
    return {
      currPost: {},
      posts: [],
      currentPage: 0,
      pages: 0
    }
  },
  methods: {
    nextPage() {
      this.currentPage++
      this.currPost = this.posts[this.currentPage]
    },
    prevPage() {
      this.currentPage--
      this.currPost = this.posts[this.currentPage]
    }
  },
  mounted () {
    var baseUrl = process.env.VUE_APP_BASE_URL
    axios
      .get(baseUrl + '/techBlog')
      .then(response => {
        this.posts = response.data
        this.currPost = this.posts[0]
        this.pages = this.posts.length
      })
      .catch(error => console.log(error))
  }
} 
</script>
