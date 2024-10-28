<script setup>
import { RouterLink, RouterView } from "vue-router";
</script>

<template>
  <header>
    <nav class="navbar navbar-expand-md bg-dark" data-bs-theme="dark">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">Pet's hotel</a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarText"
          aria-controls="navbarText"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
          <ul class="navbar-nav me-auto mb-lg-0">
            <li class="nav-item">
              <RouterLink :to="{ name: 'home' }" class="nav-link active" aria-current="page">Home</RouterLink>
            </li>
            <li class="nav-item">
              <RouterLink :to="{ name: 'all_owners' }" class="nav-link" aria-current="page">Owners</RouterLink>
            </li>
            <li class="nav-item">
              <RouterLink :to="{ name: 'all_employees' }" class="nav-link" aria-current="page">Employees</RouterLink>
            </li>
            <li class="nav-item">
              <RouterLink :to="{ name: 'all_species' }" class="nav-link" aria-current="page">Species</RouterLink>
            </li>
            <li class="nav-item">
              <RouterLink :to="{ name: 'all_typefeed' }" class="nav-link" aria-current="page">Types feed</RouterLink>
            </li>
            <li class="nav-item">
              <RouterLink :to="{ name: 'all_feeds' }" class="nav-link" aria-current="page">Feeds</RouterLink>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  </header>

  <RouterView />
</template>
