let IssueListCreator = (function () {
  let createIssueList = function (issues) {
    let issueList = document.createElement('div');
    issueList.classList.add('issue-list');

    let header = document.createElement('div');
    header.classList.add('issue-list-header');

    let idColumn = document.createElement('div');
    idColumn.classList.add('id-column');
    idColumn.appendChild(document.createTextNode('Issue ID'));
    header.appendChild(idColumn);

    let titleColumn = document.createElement('div');
    titleColumn.classList.add('title-column');
    titleColumn.appendChild(document.createTextNode('Title'));
    header.appendChild(titleColumn);

    let descriptionColumn = document.createElement('div');
    descriptionColumn.classList.add('description-column');
    descriptionColumn.appendChild(document.createTextNode('Description'));
    header.appendChild(descriptionColumn);

    let actionsColumn = document.createElement('div');
    actionsColumn.classList.add('actions-column');
    actionsColumn.appendChild(document.createTextNode('Actions'));
    header.appendChild(actionsColumn);

    issueList.appendChild(header);

    for (const issue of issues) {
      let issueItem = document.createElement('div');

      let id = document.createElement('div');
      id.classList.add('issue-list-column', 'issue-id');
      id.appendChild(document.createTextNode(issue.id));
      issueItem.appendChild(id);

      let title = document.createElement('div');
      title.classList.add('issue-list-column', 'issue-title');
      title.appendChild(document.createTextNode(issue.title));
      issueItem.appendChild(title);

      let description = document.createElement('div');
      description.classList.add('issue-list-column', 'issue-description');
      description.appendChild(document.createTextNode(issue.description));
      issueItem.appendChild(description);

      let deleteButton = document.createElement('div');
      deleteButton.classList.add('delete-button');
      deleteButton.appendChild(document.createTextNode('x'));
      deleteButton.addEventListener('click', function (event) {
        (async () => {
          await fetch('http://localhost:8080/issues/delete/' + issue.id, {
            method: 'DELETE',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            }
          });
          window.location.reload();
        })();
      })
      issueItem.appendChild(deleteButton);

      issueList.appendChild(issueItem);
    }
    return issueList;
  };

  return {
    create: createIssueList
  }
})();