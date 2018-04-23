import random

class CS(object):
    def __init__(self, name):
        self.name = name

    def act(self, tick, environment):
        hello = 'hi my namen is ' + self.name
        return hello

class FireFighter(CS):
    def __init__(self, name, prob):
        super(FireFighter, self).__init__(name)
        self.probability = prob
        self.location = -1
        self.rescued = 0

    def act(self, tick, environment):
        if random.uniform(0, 1) < self.probability:
            if self.location == -1:
                self.location = random.randrange(0, len(environment))
            else:
                self.location = (self.location + 1) % len(environment)

            hello = 'Hi my name is ' + self.name + ". I'm on " + str(self.location) + '.'
            if environment[self.location] > 0:
                self.rescued = self.rescued + 1
                environment[self.location] = environment[self.location] - 1
                hello = hello + ' I rescued a patient ' + str(environment)

            return hello

    def reset(self):
        self.location = -1
        self.rescued = 0