Backjack
========

## Reason
A simple blackjack simulator implemented in Java. This project is is a game masquerading as a mongodb benchmark.  Currently this program runs untill killed and simulates blackjack hands over and over again.  The dealer follows vagas rules and will sit on a soft 17. The player on the other hand always sits.  Yes, its stupid however hands do not take long to simulate :). Implementing a smarter player is simple and involves extending an abstract class.

## Future
I have already started work on Kent Brockman. A reporting tool for this simulator.  It tracks all sorts of things like win rates and play speed. Once I have some basic reporting working I would like to implement a smarter player class. One that remembers hands and then acts on prior knowledge. I am sure we can get that 20% win rate  for the player up to at least 40%.

## Performance
This section is more about how awesome mongodb is really. Currently the simulator generates around 17,000 hands a second! I left it running for a few hours and it generated over 400,000,000 hands. Mongodb did not even blink. Awesome work 10gen!  Now all i need to do is start working on my map reduce skills to make sense of all this data.
