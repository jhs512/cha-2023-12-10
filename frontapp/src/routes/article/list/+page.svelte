<script lang="ts">
    import createClient from "openapi-fetch";
    import { paths } from "$lib/../types/schema"; // generated from openapi-typescript

    const { GET, PUT } = createClient<paths>({ baseUrl: "http://localhost:8080" });


    let articles = $state([]);

    function load() {
        GET("/api/v1/articles", {

        })
    }

    $effect(() => {
        load();
    });

    let title = $state('');
    let body = $state('');

    function submit(event) {
        event.preventDefault();

        fetch('http://localhost:8080/api/v1/articles', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                title,
                body,
            }),
        })
            .then(response => response.json())
            .then(data => {
                load();
            })
            .catch(error => console.error(error));
    }
</script>

<ul>
    {#each articles as article}
        <li>{article.title}</li>
    {/each}
</ul>

<form on:submit={submit}>
    <input type="text" bind:value={title}>
    <input type="text" bind:value={body}>
    <input type="submit" value="버튼"/>
</form>

<a href="/">메인</a>