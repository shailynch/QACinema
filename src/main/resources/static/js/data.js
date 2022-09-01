let defaultThreads = [
    {
        id: 1,
        title: "General QACinema chatter",
        author: "Admin",
        date: Date.now(),
        content: "QACinema Chatter",
        comments: [
            {
                author: "Jack",
                date: Date.now(),
                content: "Love this Cinema!"
            },
            {
                author: "Arthur",
                date: Date.now(),
                content: "Seats are great!"
            }
        ]
    },
    {
        id: 2,
        title: "Marvel Film discussion",
        author: "Admin",
        date: Date.now(),
        content: "Everything Marvel",
        comments: [
            {
                author: "Jack",
                date: Date.now(),
                content: "Hey there"
            },
            {
                author: "Arthur",
                date: Date.now(),
                content: "Hey to you too"
            }
        ]
    },
    {
        id: 3,
        title: "RomComs 4 life",
        author: "Admin",
        date: Date.now(),
        content: "QACinema Chatter",
        comments: [
            {
                author: "Jack",
                date: Date.now(),
                content: "Love this Cinema!"
            },
            {
                author: "Arthur",
                date: Date.now(),
                content: "Seats are great!"
            }
        ]
    }
]

let threads = defaultThreads
if (localStorage && localStorage.getItem('threads')) {
    threads = JSON.parse(localStorage.getItem('threads'));
} else {
    threads = defaultThreads;
    localStorage.setItem('threads', JSON.stringify(defaultThreads));
}

function clearStorage(){
    let session = sessionStorage.getItem('threads');
    if (session == null) {
        localStorage.removeItem('threads');
    }
    sessionStorage.getItem('threads');

}
window.addEventListener('load', clearStorage);