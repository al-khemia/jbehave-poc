Meta:

Narrative:
As a tester
I want to interact with web elements
So that I can move them into the page

Scenario: Dropping a Box
Given I open http://demoqa.com/droppable/
When I drag a box with a target
Then Target has changed its text

Scenario: Dragging a Box
Given I open http://demoqa.com/draggable/
When I drag a box 100 to the right and 200 below
Then The box has changed the position

