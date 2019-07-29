<h1 align="center">Welcome to Wanderlust Backend :world_map:</h1>
<p>
  <a href="https://github.com/build-week-wanderlust/back-end/blob/master/LICENSE">
    <img alt="License: MIT" src="https://img.shields.io/badge/License-MIT-yellow.svg" target="_blank" />
  </a>
  <a href="https://twitter.com/Andrew_Brudnak">
    <img alt="Twitter: Andrew_Brudnak" src="https://img.shields.io/twitter/follow/Andrew_Brudnak.svg?style=social" target="_blank" />
  </a>
</p>

> Wanderlust helps local tour guides of all types advertise their private/professional trips and experiences they offer.

## :card_file_box: Example of Experiences Data Returned

```json
[
    {
        "experienceid": 6,
        "title": "Wine Tasting",
        "description": "For wine enthusiasts, the Sonoma and Napa Valleys are often the pinnacle of the North American wine experience. However, for the uninitiated, choosing where and when to go can be a little daunting. This coach tour shuttles you in style to three famous wineries in northern California: Madonna Estate, Sebastiani Vineyards and Sutter Home. Stop for lunch in historic downtown Sonoma Square, where you'll find a bevy of dining options and boutique shops for exploration.",
        "city": "San Francisco",
        "state": "CA",
        "price": 135.0,
        "user": {
            "userid": 5,
            "username": "andrew",
            "userRoles": [
                {
                    "role": {
                        "roleid": 3,
                        "name": "data"
                    }
                },
                {
                    "role": {
                        "roleid": 2,
                        "name": "user"
                    }
                }
            ],
            "authority": [
                {
                    "authority": "ROLE_DATA"
                },
                {
                    "authority": "ROLE_USER"
                }
            ]
        }
    },
    {
        "experienceid": 7,
        "title": "Wine Country by Helicopter",
        "description": "Fly by helicopter from the San Francisco Bay Area to Wine Country during this tour. Enjoy views of the city, the Golden Gate Bridge, Alcatraz and Wine Country's rolling vineyards before touching down at one of the area's most prestigious wineries. Enjoy a guided tour of the property, tapas and a wine tasting. With your small group limited to 6 people, learn about the winery's world-class varietals and all the love and labor that goes into making the perfect cabernet. When your 3-hour excursion is over, travel back to San Francisco by helicopter.",
        "city": "San Francisco",
        "state": "CA",
        "price": 460.0,
        "user": {
            "userid": 5,
            "username": "andrew",
            "userRoles": [
                {
                    "role": {
                        "roleid": 3,
                        "name": "data"
                    }
                },
                {
                    "role": {
                        "roleid": 2,
                        "name": "user"
                    }
                }
            ],
            "authority": [
                {
                    "authority": "ROLE_DATA"
                },
                {
                    "authority": "ROLE_USER"
                }
            ]
        }
    }
]
```

## Author

:grinning: **Andrew Brudnak**

-   Twitter: [@Andrew_Brudnak](https://twitter.com/Andrew_Brudnak)
-   Github: [@brudnak](https://github.com/brudnak)

## Show your support

Give a :star2: if this project helped you!

## 📝 License

Copyright © 2019 [Andrew Brudnak](https://github.com/brudnak).<br />
This project is [MIT](https://github.com/build-week-wanderlust/back-end/blob/master/LICENSE) licensed.

---

_This README was generated with :sparkling_heart: by [readme-md-generator](https://github.com/kefranabg/readme-md-generator)_
