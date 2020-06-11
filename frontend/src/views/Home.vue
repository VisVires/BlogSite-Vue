<template>
  <div class="home">
    <div class="jumbotron">
        <b-jumbotron>
        </b-jumbotron>
    </div>
    <b-form-row>
      <b-col cols="1"/>
      <b-col>
        <div class="blog-header">
          <h1 style="text-align: left" class="blog-title"><strong>Blog Input</strong></h1>
          <p class="lead blog-description">Just a place to easily update the existing data on my site!</p>
          <hr class="style3">
        </div>
        <b-card no-body>
          <b-tabs card>
            <b-tab title="Add Blog Post" active>
              <BlogForm/>
            </b-tab>
            <b-tab title="Add Quote">
              <QuoteForm/>
            </b-tab>
            <b-tab title="Add Project">
              <ProjectForm/>
            </b-tab>
          </b-tabs>
        </b-card>
      </b-col>
      <b-col cols="1"/>
    </b-form-row>
  </div>
</template>

<script>

import BlogForm from '@/components/BlogForm.vue'
import QuoteForm from '@/components/QuoteForm.vue'
import ProjectForm from '@/components/ProjectForm.vue'


export default {
  name: 'Home',
  components: {
    BlogForm,
    QuoteForm,
    ProjectForm
  }
}
</script>
