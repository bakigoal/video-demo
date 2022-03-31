const form = document.querySelector('#video-form');
const videoDiv = document.querySelector('#video-player');
const videoScreen = document.querySelector('#video-screen');

const queryParams = Object.fromEntries(new URLSearchParams(window.location.search));

const BASE_URL = 'http://localhost:8080/video'

fetch(`${BASE_URL}/all`)
    .then(result => result.json())
    .then(result => {

        const myVids = document.querySelector('#your-videos');
        if (result.length > 0) {
            for (let vid of result) {
                const li = document.createElement('LI');
                const link = document.createElement('A');
                link.innerText = vid;
                link.href = window.location.origin + window.location.pathname + '?video=' + vid;
                li.appendChild(link);
                myVids.appendChild(li);
            }
        } else {
            myVids.innerHTML = 'No videos found';
        }

    });

if (queryParams.video) {
    videoScreen.src = `${BASE_URL}/${queryParams.video}`;
    videoDiv.style.display = 'block';
    document.querySelector('#now-playing')
        .innerText = 'Now playing ' + queryParams.video;
}

form.addEventListener('submit', ev => {
    ev.preventDefault();
    let data = new FormData(form);
    fetch(`${BASE_URL}`, {
        method: 'POST',
        body: data
    }).then(result => result.text()).then(_ => {
        window.location.reload();
    });
});