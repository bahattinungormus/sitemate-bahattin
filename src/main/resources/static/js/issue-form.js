let IssueFormCreator = (function () {
  function createForm() {
    let issueForm = document.createElement('form');
    issueForm.id = 'issue-form';
    issueForm.className = 'issue-form';

    let fieldSet = document.createElement('fieldset');

    let titleInput = document.createElement('input');
    titleInput.setAttribute('type', 'text');
    titleInput.setAttribute('id', 'title');
    titleInput.className = 'title-input';
    titleInput.name = 'title';

    let titleLabel = document.createElement('label');
    titleLabel.setAttribute('for', 'title');
    titleLabel.appendChild(document.createTextNode('Title'));

    fieldSet.appendChild(titleLabel);
    fieldSet.appendChild(titleInput);

    let descriptionInput = document.createElement('textarea');
    descriptionInput.setAttribute('type', 'text');
    descriptionInput.setAttribute('id', 'description');
    descriptionInput.className = 'description-input';
    descriptionInput.name = 'description';
    // descriptionInput.rows = 10;
    // descriptionInput.cols = 200;

    let descriptionLabel = document.createElement('label');
    descriptionLabel.setAttribute('for', 'description');
    descriptionLabel.appendChild(document.createTextNode('Description'));

    fieldSet.appendChild(descriptionLabel);
    fieldSet.appendChild(descriptionInput);

    issueForm.appendChild(fieldSet);

    let formControls = document.createElement('div');
    formControls.id = 'issue-form-controls';
    formControls.className = 'issue-form-controls';

    let saveButton = document.createElement('button');
    saveButton.setAttribute('type', 'button');
    saveButton.className = 'save-button';
    saveButton.appendChild(document.createTextNode('Save'));
    formControls.appendChild(saveButton);
    let cancelButton = document.createElement('button');
    cancelButton.setAttribute('type', 'button');
    cancelButton.className = 'cancel-button';
    cancelButton.appendChild(document.createTextNode('Cancel'));
    formControls.appendChild(cancelButton);

    issueForm.appendChild(formControls);

    saveButton.addEventListener('click', function (event) {
      let formData = new FormData(issueForm);
      (async () => {
        const rawResponse = await fetch('http://localhost:8080/issues/save', {
          method: 'POST',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(Object.fromEntries(formData))
        });
        const content = await rawResponse.json();

        console.log(content);
        
        document.location.reload();
      })();
    });

    cancelButton.addEventListener('click', function (event) {
      issueForm.reset();
    })

    return issueForm;
  }

  return {
    create: createForm
  };
})();