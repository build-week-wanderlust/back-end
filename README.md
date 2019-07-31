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

## :clipboard: [Available API End Points](https://brudnak-wanderlust.herokuapp.com/swagger-ui.html#/)

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
    "triptype": "Professional",
    "user": {
      "userid": 5,
      "username": "AndrewB",
      "profile": {
        "profileid": 14,
        "firstname": "Andrew",
        "lastname": "Brudnak",
        "email": "brudnak@icloud.com",
        "telephone": "505-474-7549",
        "about": "Offering Wine Inspired Experiences"
      }
    }
  },
  {
    "experienceid": 7,
    "title": "Wine Country by Helicopter",
    "description": "Fly by helicopter from the San Francisco Bay Area to Wine Country during this tour. Enjoy views of the city, the Golden Gate Bridge, Alcatraz and Wine Country's rolling vineyards before touching down at one of the area's most prestigious wineries. Enjoy a guided tour of the property, tapas and a wine tasting. With your small group limited to 6 people, learn about the winery's world-class varietals and all the love and labor that goes into making the perfect cabernet. When your 3-hour excursion is over, travel back to San Francisco by helicopter.",
    "city": "San Francisco",
    "state": "CA",
    "price": 460.0,
    "triptype": "Private",
    "user": {
      "userid": 5,
      "username": "AndrewB",
      "profile": {
        "profileid": 14,
        "firstname": "Andrew",
        "lastname": "Brudnak",
        "email": "brudnak@icloud.com",
        "telephone": "505-474-7549",
        "about": "Offering Wine Inspired Experiences"
      }
    }
  },
  {
    "experienceid": 9,
    "title": "Florida Air Boat Ride",
    "description": "Our experienced captains have a knack for being able to spot alligators, eagles and other wildlife that build their homes in the waterways near Wild Florida. Each time you head out onto the water, you’ll see and experience something different.",
    "city": "Kenansville",
    "state": "FL",
    "price": 59.0,
    "triptype": "Professional",
    "user": {
      "userid": 8,
      "username": "RussellF",
      "profile": {
        "profileid": 16,
        "firstname": "Russell",
        "lastname": "Freckingham",
        "email": "rufreckingham@gmail.com",
        "telephone": "898-804-9302",
        "about": "Air boat tours are the best way to see Florida's exotic wild life!"
      }
    }
  },
  {
    "experienceid": 10,
    "title": "Gator Encounter",
    "description": "Go behind-the-scenes of our Gator Feeding Show with one of our animal educators to feed dozens of huge, hungry gators ready for their next meal. While in the crows nest, play one of our alligators’ favorite games… jumping for chicken! ",
    "city": "Kenansville",
    "state": "FL",
    "price": 21.0,
    "triptype": "Professional",
    "user": {
      "userid": 8,
      "username": "RussellF",
      "profile": {
        "profileid": 16,
        "firstname": "Russell",
        "lastname": "Freckingham",
        "email": "rufreckingham@gmail.com",
        "telephone": "898-804-9302",
        "about": "Air boat tours are the best way to see Florida's exotic wild life!"
      }
    }
  },
  {
    "experienceid": 12,
    "title": "Alaska Seaplane Tour",
    "description": "Departing from Ketchikan in our beautiful seaplane, our tour will take us through the Misty Fjords National Monument and north to the prehistoric land of the Alaska Glacier.",
    "city": "Ketchikan",
    "state": "AK",
    "price": 550.0,
    "triptype": "Professional",
    "user": {
      "userid": 11,
      "username": "RubyB",
      "profile": {
        "profileid": 18,
        "firstname": "Ruby",
        "lastname": "Bernhardi",
        "email": "rbernhardir92@gmail.com",
        "telephone": "969-317-4943",
        "about": "Experiences in Alaska, the last frontier"
      }
    }
  },
  {
    "experienceid": 13,
    "title": "Ketchikan Shore Excursion: Zodiac Boat Wilderness Adventure",
    "description": "Leave your cruise ship behind for a few hours and steer a Zodiac boat in the waters of the Alaskan wilderness. This small-group guided shore excursion from Ketchikan is limited to just four people, and everyone takes a turn at the wheel. Cruise through rain-forest islands, into remote bays and inlets, and spot wildlife including eagles, seals, whales and bears. Enjoy a beachside snack and a boatman certificate to take home as a souvenir. Round-trip port transport is included.",
    "city": "Ketchikan",
    "state": "AK",
    "price": 179.0,
    "triptype": "Professional",
    "user": {
      "userid": 11,
      "username": "RubyB",
      "profile": {
        "profileid": 18,
        "firstname": "Ruby",
        "lastname": "Bernhardi",
        "email": "rbernhardir92@gmail.com",
        "telephone": "969-317-4943",
        "about": "Experiences in Alaska, the last frontier"
      }
    }
  }
]
```

## Author

:grinning: **Andrew Brudnak**

- Twitter: [@Andrew_Brudnak](https://twitter.com/Andrew_Brudnak)
- Github: [@brudnak](https://github.com/brudnak)

## Show your support

Give a :star2: if this project helped you!

## 📝 License

Copyright © 2019 [Andrew Brudnak](https://github.com/brudnak).<br />
This project is [MIT](https://github.com/build-week-wanderlust/back-end/blob/master/LICENSE) licensed.

---

_This README was generated with :sparkling_heart: by [readme-md-generator](https://github.com/kefranabg/readme-md-generator)_
