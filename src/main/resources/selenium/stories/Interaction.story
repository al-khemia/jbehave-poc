Meta:

Narrative:
As a tester
I want to interact with web elements
So that I can move them into the page

Scenario: Dragging a Box
Given I open http://demoqa.com/draggable/
When I drag a box 100 to the right and 200 below
Then The box has changed the position