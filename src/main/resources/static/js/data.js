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
    },
    {
        id: 4,
        title: "Harry Potter Fan Club",
        author: "Admin",
        date: Date.now(),
        content: "QACinema Chatter",
        comments: [
            {
                author: "Billy",
                date: Date.now(),
                content: "So magical"
            },
            {
                author: "Johanna",
                date: Date.now(),
                content: "I love the owls"
            }
        ]
    },
    {
        id: 5,
        title: "80s feel-good films",
        author: "Admin",
        date: Date.now(),
        content: "QACinema Chatter",
        comments: [
            {
                author: "Jebediah",
                date: Date.now(),
                content: "Bring back Snake Pliskin"
            },
            {
                author: "Edward",
                date: Date.now(),
                content: "Kurt Russel the GOAT"
            }
        ]
    },
    {
        id: 6,
        title: "New Releases",
        author: "Admin",
        date: Date.now(),
        content: "New film release discussion",
        comments: [
            {
                author: "Samantha",
                date: Date.now(),
                content: "Film season is upon us"
            },
            {
                author: "Samuel",
                date: Date.now(),
                content: "New Lord of the Rings when?"
            }
        ]
    },
    {
        id: 7,
        title: "Snack Requests",
        author: "Admin",
        date: Date.now(),
        content: "What film snacks should we stock?",
        comments: [
            {
                author: "Marlton",
                date: Date.now(),
                content: "Jelly beans are scientifically the best sweet"
            },
            {
                author: "Abigail",
                date: Date.now(),
                content: "Shut up Marlton"
            }
        ]
    },
    {
        id: 8,
        title: "Horror Central",
        author: "Admin",
        date: Date.now(),
        content: "Board for Horror Fanatics",
        comments: [
            {
                author: "Pablo",
                date: Date.now(),
                content: "Run Halloween on repeat please"
            },
            {
                author: "Anton",
                date: Date.now(),
                content: "Just show anything John Carpenter works on!"
            }
        ]
    },
    {
        id: 9,
        title: "Comedy Hour",
        author: "Admin",
        date: Date.now(),
        content: "Board for Comedy lovers",
        comments: [
            {
                author: "Tank",
                date: Date.now(),
                content: "We love Kevin Hart"
            },
            {
                author: "Takeo",
                date: Date.now(),
                content: "Can you show stand up shows?"
            }
        ]
    },
    {
        id: 10,
        title: "The Dramatic Ones",
        author: "Admin",
        date: Date.now(),
        content: "Board for Drama fans",
        comments: [
            {
                author: "Bill",
                date: Date.now(),
                content: "Titanic Remake when?"
            },
            {
                author: "Phyllis",
                date: Date.now(),
                content: "Downton Abbey <3"
            }
        ]
    },
    {
        id: 11,
        title: "Detectives Unite",
        author: "Admin",
        date: Date.now(),
        content: "Board for mystery lovers",
        comments: [
            {
                author: "Bill",
                date: Date.now(),
                content: "Titanic Remake when?"
            },
            {
                author: "Phyllis",
                date: Date.now(),
                content: "Downton Abbey <3"
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
