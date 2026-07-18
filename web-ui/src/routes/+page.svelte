<script lang="ts">
  import { dev } from "$app/environment";
  import MainPage from "$lib/components/MainPage.svelte";
  import type { Application } from "$lib/model/Application";
  import { onMount } from "svelte";

  let application: Application | null = null

  const URL = dev ? "/sample.json" : "/api/"

  async function fetchAndUpdate() {
    const result = await fetch(URL)
    const json = await result.json()
    application = json;
    setTimeout(fetchAndUpdate, 4_000)
  }

  onMount(async () => {
    fetchAndUpdate()
  })

</script>

{#if application}
  <MainPage {application}/>
{:else}
  <p>Loading...</p>
{/if}

