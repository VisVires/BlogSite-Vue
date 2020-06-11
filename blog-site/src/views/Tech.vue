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
          <TechBlog></TechBlog>
        </div>
        <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
          <div class="sidebar-module sidebar-module-inset">
            <h4>About</h4>
              <p>The purpose of this blog is to both give the reader a window into <em>what I'm learning right now</em> and specific topics that interest me in the broad world of Computer Science</p>
          </div>
          <div class="sidebar-module">
            <h4>Archives</h4>
            <ol class="list-unstyled">
            </ol>
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

export default {
  name: 'Tech',
  components: {
    Quote,
    TechBlog
  }
}
</script>
