function openBlogDetail(button) {
    const title = button.dataset.title;
    const content = button.dataset.content;
    const category = button.dataset.category;

    const body = `
        <h5>${title}</h5>
        <hr>
        <p>${content}</p>
        <span class="badge bg-secondary">${category}</span>
    `;

    document.getElementById("modalBody").innerHTML = body;

    document.getElementById("modalAction").style.display = "none";

    new bootstrap.Modal(
        document.getElementById("commonModal")
    ).show();
}

